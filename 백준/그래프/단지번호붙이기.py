import sys
from collections import deque

def bfs(x, y):
    visited[x][y] = True
    q = deque()
    q.append([x,y])
    l = [[-1, 0], [0, 1], [1, 0], [0, -1]]

    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0] + l[i][0]
            ny = now[1] + l[i][1]
            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and m[nx][ny] == 1:
                    danzi[cnt] += 1
                    bfs(nx, ny)


n = int(sys.stdin.readline())
m = [[] for _ in range(n)]
answer = 0
danzi = []
cnt = 0
visited = [[False] * n for _ in range(n)]

for i in range(n):
    s = sys.stdin.readline().rstrip()
    for c in s:
        m[i].append(int(c))

for i in range(n):
    for j in range(n):
        if not visited[i][j] and m[i][j] == 1:
            answer += 1
            danzi.append(1)
            bfs(i, j)
            cnt += 1

danzi.sort()

print(answer)
for e in danzi:
    print(e)
