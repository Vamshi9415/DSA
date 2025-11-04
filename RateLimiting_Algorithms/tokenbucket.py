import asyncio
import time
MAX_TOKENS = 5
REFILL_RATE = 5

class TokenBucket :
    def __init__(self,max_tokens,refill_rate):
        self.max_tokens = max_tokens
        self.tokens = max_tokens
        self.refill_rate = refill_rate
    
    def has_tokens(self):
        ''' check if tokens are available'''
        self.tokens > 0
    
    def consume_token(self):
        if self.has_tokens():
            self.tokens -=1
            
            return True
        
        return False
    
    def release_token(self):
        '''refill tokens if bucket not full'''
        if self.tokens < self.max_tokens:
            self.tokens +=1

bucket = TokenBucket(MAX_TOKENS,REFILL_RATE)

async def handle_incoming_request(request_id):
    if not bucket.has_tokens() :
        print(f"out of tokens : try again later {request_id} ")
        return
    
    bucket.consume_token()
    
    print(f"Processing Request {request_id}")
    
    asyncio.sleep(2)
    
    print(f"Done Request {request_id}")

async def refill_tokens():
    ''' Continously refill tokens '''
    
    while True :
        await asyncio.sleep(bucket.refill_rate)
        bucket.release_token()
        
    
        