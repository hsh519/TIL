import sys
from collections import deque

def bfs(x, y):
    visited[x][y] = True
    l = [[-1,0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
    q = deque()
    q.append([x,y])
    while q:
        now = q.popleft()
        for i in range(8):
            nx = now[0] + l[i][0]
            ny = now[1] + l[i][1]
            if 0 <= nx < m and 0 <= ny < n:
                if not visited[nx][ny] and mp[nx][ny] == 1:
                    visited[nx][ny] = True
                    q.append([nx,ny])

while True:
    n, m = map(int,sys.stdin.readline().rsplit())
    visited = [[False] * n for _ in range(m)]
    mp = []
    answer = 0
    if n == 0 and m == 0:
        break

    for i in range(m):
        mp.append(list(map(int, sys.stdin.readline().rsplit())))
            
    for i in range(m):
        for j in range(n):
            if not visited[i][j] and mp[i][j] == 1:
                answer += 1
                bfs(i, j)

    print(answer)