import sys
from collections import deque

def bfs(visited, cnt = 0):
    q = deque()
    q.append(1)
    visited[1] = True

    while q and False in visited:
        now = q.popleft()

        for v in node[now]:
            if not visited[v]:
                cnt += 1
                visited[v] = True
                q.append(v)

    return cnt

t = int(sys.stdin.readline())

for i in range(t):
    n, m = map(int, sys.stdin.readline().rsplit())
    visited = [False] * (n+1)
    node = {}

    for j in range(m):
        a, b = map(int, sys.stdin.readline().rsplit())
        if a in node.keys():
            node[a].append(b)
        else:
            node[a] = [b]
        
        if b in node.keys():
            node[b].append(a)
        else:
            node[b] = [a]
    
    cnt = bfs(visited)
    print(cnt)