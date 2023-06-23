import sys
from collections import deque

def bfs(start, cnt = 0):
    q = deque()
    q.append([start, cnt])
    d = [1, -1, 2]

    while q:
        x, res = q.popleft()
        if x == m:
            return res
        for i in range(len(d)):
            if i == 2:
                dx = x * d[i]
            else:
                dx = x + d[i]
            if 0 <= dx <= 100000:
                if not visited[dx]:
                    visited[dx] = True
                    q.append([dx, res+1])

n, m = map(int, sys.stdin.readline().rsplit())
visited = [False] * 100001
print(bfs(n))