import sys

n, m = map(int, sys.stdin.readline().rsplit())
q = []
graph = [[] for _ in range(n+1)]
dg = [0] * (n+1)
answer = []

for _ in range(m):
    a,b = map(int, sys.stdin.readline().rsplit())
    graph[a].append(b)
    dg[b] += 1

for i in range(1,len(dg)):
    if dg[i] == 0:
        q.append(i)

while q:
    q.sort(reverse=True)
    now = q.pop()
    answer.append(now)
    for i in graph[now]:
        dg[i] -= 1
        if dg[i] == 0:
            q.append(i)
            
print(*answer)


