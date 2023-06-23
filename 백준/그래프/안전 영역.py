import sys
from collections import deque

def bfs(x, y, h, visited):
    q = deque()
    q.append([x,y])

    d = [[1, 0], [0, 1], [-1, 0], [0, -1]]

    while q:
        a, b = q.popleft()
        
        for i in d:
            na = a + i[0]
            nb = b + i[1]

            if 0 <= na < n and 0 <= nb < n:
                if not visited[na][nb]:
                    if ls[na][nb] > h:
                        visited[na][nb] = True
                        q.append([na, nb])

n = int(sys.stdin.readline())
ls = []
max_num = 0
min_num = 101
answer = []

for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().rsplit())))

for i in range(n):
    for j in range(n):
        if max_num < ls[i][j]:
            max_num = ls[i][j]
        if min_num > ls[i][j]:
            min_num = ls[i][j]


for i in range(0, max_num):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if visited[j][k] == True or ls[j][k] <= i:
                continue
            bfs(j, k, i, visited)
            cnt += 1
    answer.append(cnt)

print(max(answer))