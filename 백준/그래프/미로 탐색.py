import sys
from collections import deque

def bfs(x, y, answer):
    visited[x][y] = True
    l = [[0, 1], [1, 0], [-1, 0], [0, -1]]
    q = deque()
    q.append([x, y])
    
    while q:
        if len(next) == answer+1:
            next.append(0)
        next[answer] -= 1

        now = q.popleft()
        if now[0] == n-1 and now[1] == m-1:
            print(answer)
            break

        if next[answer] == 0:
            answer += 1
        
        for i in range(4):
            nx = now[0] + l[i][0]
            ny = now[1] + l[i][1]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and mp[nx][ny] == 1:
                    visited[nx][ny] = True
                    next[-1] += 1
                    q.append([nx, ny])
    
n, m = map(int, sys.stdin.readline().rsplit())
mp = [[] for _ in range(n)]
visited = [[False] * m for _ in range(n)]
ls = [2, 2]
next = [0, 1]
answer = 1

for i in range(n):
    s = sys.stdin.readline().rstrip()
    for c in s:
        mp[i].append(int(c))

bfs(0,0,answer)