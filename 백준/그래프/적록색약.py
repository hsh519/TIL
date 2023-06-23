import sys
from collections import deque

def dfs(start, list, visited):
    q = deque()
    q.append(start)
    d = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    while q:
        x, y = q.popleft()

        for i in d:
            nx = x + i[0]
            ny = y + i[1]

            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny]:
                    if ls[nx][ny] in list:
                        visited[nx][ny] = True
                        q.append([nx, ny])

n = int(sys.stdin.readline())
store = []
ls = []
visited = [[False] * n for _ in range(n)]
cnt = 0
answer = []

for i in range(n):
    store.append(sys.stdin.readline().rstrip())

for s in store:
    res = []
    for c in s:
        res.append(c)
    ls.append(res)

for i in range(n):
    for j in range(n):
        if visited[i][j]:
            continue
        dfs([i,j], [ls[i][j]], visited)
        cnt += 1

answer.append(cnt)
visited = [[False] * n for _ in range(n)]
cnt = 0

for i in range(n):
    for j in range(n):
        if visited[i][j]:
            continue
        
        if ls[i][j] == 'R' or ls[i][j] == 'G':
            dfs([i,j], ['R', 'G'], visited)
            cnt += 1
        else:
            dfs([i,j], ['B'], visited)
            cnt += 1

answer.append(cnt)
print(*answer)