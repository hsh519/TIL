import sys
from collections import deque
import copy

def virus(ls, virus_list, safe):
    q = deque()
    for e in virus_list:
        q.append(e)

    d = [[-1,0], [0,1], [1,0], [0,-1]]

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + d[i][0]
            ny = y + d[i][1]

            if 0 <= nx < n and 0 <= ny < m:
                if ls[nx][ny] == 0:
                    safe -= 1
                    ls[nx][ny] = 2
                    q.append([nx, ny])
    return safe

n, m = map(int, sys.stdin.readline().rsplit())
ls = []
virus_list = []
safe = -3
after_virus = 0

for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().rsplit())))

for i in range(len(ls)):
    for j in range(len(ls[i])):
        if ls[i][j] == 2:
            virus_list.append([i,j])

    safe += ls[i].count(0)

for i in range(n*m-2):
    for j in range(i+1,n*m-1):
        for k in range(j+1, n*m):
            if ls[i//m][i%m] == 0 and ls[j//m][j%m] == 0 and ls[k//m][k%m] == 0:
                ls[i//m][i%m], ls[j//m][j%m], ls[k//m][k%m] = 1, 1, 1
                after_virus = max(after_virus, virus(copy.deepcopy(ls), virus_list, safe))
                ls[i//m][i%m], ls[j//m][j%m], ls[k//m][k%m] = 0, 0, 0

print(after_virus) 
                