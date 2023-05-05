import sys
from collections import defaultdict, deque


for _ in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())
    node = list(map(int,sys.stdin.readline().rsplit()))
    graph = defaultdict(list)
    for i in range(n):
        if i == n-1:
            graph[node[i]].append(0)
        for j in range(i+1, n):
            graph[node[i]].append(node[j])
    dg = defaultdict(int)
    for i in range(n):
        dg[node[i]] += i
    q = deque()
    answer = []

    for _ in range(int(sys.stdin.readline())):
        a,b = map(int, sys.stdin.readline().rsplit())
        if b in graph[a]:
            graph[b].append(a)
            graph[a].remove(b)
            dg[b] -= 1
            dg[a] += 1
        else:
            graph[a].append(b)
            graph[b].remove(a)
            dg[a] -= 1
            dg[b] += 1
          
    for i in node:
        if dg[i] == 0:
            q.append(i)
            
    while q:
        now = q.popleft()
        answer.append(now)
        for i in graph[now]:
            dg[i] -= 1
            if dg[i] == 0:
                q.appendleft(i)

    if len(answer) != n:
        print("IMPOSSIBLE")
    else:
        print(*answer)

