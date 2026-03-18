# basic code 
# from collections import OrderedDict

# d = OrderedDict()

# d[1] = 2
# d.update({2:3})
# d.update({3:3})
# d.move_to_end(2, last=False)
# print(d)
# print(d.popitem())

# LRU Order Rule
# Position	Meaning
# LEFT	Least Recently Used
# RIGHT	Most Recently Used
from collections import OrderedDict
import time
from threading import Lock 

class CacheEntry:
    def __init__(self,value,expiry):
        self.value = value
        self.expiry = expiry
        
    
class Cache:
    def __init__(self,max_entries=5, ttl = 100):
        # this is to store the elements in order, ordereddcit used bea=cause to rearrange elements 
        self.dict_cache = OrderedDict()
        self.max_entries = max_entries
        self.ttl = ttl
        #these are stats
        self.hits = 0
        self.misses = 0
        self.lock = Lock()
        
    
    def get(self, key):
        # using threaded lock to protect the cache
        with self.lock :
            entry = self.dict_cache.get(key)
            if entry is None :
                self.misses +=1
                return None



            if time.time() > entry.expiry :
                del self.dict_cache[key]
                self.misses += 1
                return None

            self.hits +=1
            # when we get the key move that to last position means that is least recently used 
            self.dict_cache.move_to_end(key) # inserting at last which is most recently used
            return entry.value
    
    def put(self,key,value):
        with self.lock:
            self._evict_expired()
            # instead of storing key-> value
            # we store key ->(value,expiry_time) entries should expire after time
            expiry = time.time() + self.ttl #100 sec TTL
            if key in self.dict_cache :
                del self.dict_cache[key]
            self.dict_cache[key] = CacheEntry(value,expiry)
            #need to limit the cache size
            while len(self.dict_cache)> self.max_entries :
                self.dict_cache.popitem(last=False) # remove the first element which is least recently used
        
    def cache_stats(self):
        with self.lock :
            total = self.misses+ self.hits 

            return {
                 "hits": self.hits,
            "misses": self.misses,
            "hit_rate": (self.hits / total * 100) if total else 0
            }
    
    # until now we are evicting only when accessed in get() this is lazy expiration
    # if key is never accessed again it stays in memory forever and wastes space 
    
    def _evict_expired(self):
        now = time.time()
        
        keys_to_delete = []
        
        for key,value in self.dict_cache.items():
            if value.expiry < now :
                keys_to_delete.append(key)
        
        for key in keys_to_delete :
            del self.dict_cache[key]
    
    def clear(self):
        with self.lock:
            count = len(self.dict_cache)
            
            self.dict_cache.clear()
            return count
        
    
    
    