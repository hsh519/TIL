import sys
from collections import deque

def bfs(x = 1):
    visited[x] = True
    q = deque()
    q.append(x)

    while q:
        now = q.popleft()
        tree.append(now)
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                q.append(i)

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
tree = []
answer = [0] * (n+1)

for i in range(n-1):
    x, y = map(int, sys.stdin.readline().rsplit())
    if x == 1:
        graph[x].append(y)
    elif y == 1:
        graph[y].append(x)
    else:
        graph[x].append(y)
        graph[y].append(x)

bfs()
tree.reverse()

for node in tree:
    if node == 1:
        break
    if graph[node] == []:
        answer[node] = [1]
    else:
        answer[node] = graph[node]
        graph[graph[node][0]].remove(node)

for node in answer[2:]:
    print(*node)