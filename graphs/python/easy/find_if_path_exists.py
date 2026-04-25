#find if path exists in graph

n = 6
edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]
source = 0
destination = 5

adj_list = {i : [] for i in range(n)} 

for u,v in edges :
    adj_list[u].append(v)
    adj_list[v].append(u)


from collections import deque 

q = deque([source])

visited = set()

visited.add(source)

while q :
    node = q.popleft()
    
    print(node)
    
    for neigh in adj_list[node]:
        
        if neigh not in visited :
            visited.add(neigh)
            q.append(neigh)
        if neigh == destination :
            print("path exists")