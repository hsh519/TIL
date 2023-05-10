import sys
from collections import deque

def bfs(graph, start, visited):
    visited[start] = True
    q = deque([start])
    while q:
        now = q.popleft()
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                q.append(i)

n, m = map(int, sys.stdin.readline().rsplit())
if m == 0:
    print(n)
else:
    graph = [[] for _ in range(n+1)]
    visited = [False] * (n+1)
    answer = 0
    for _ in range(m):
        x, y = map(int, sys.stdin.readline().rsplit())
        graph[x].append(y)
        graph[y].append(x)

    for i in range(1,len(graph)):
        if not visited[i]:
            answer += 1
            bfs(graph, i, visited)

    print(answer)
