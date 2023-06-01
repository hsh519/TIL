import sys
from copy import deepcopy
from collections import deque

def bfs(x, y, copy_visited, team, sum):
    q = deque()
    q.append([x,y])
    copy_visited[x][y] = True
    d = [[-1,0], [0,1], [1,0], [0,-1]]

    while q:
        a, b = q.popleft()

        for i in range(4):
            nx = a + d[i][0]
            ny = b + d[i][1]

            if 0 <= nx < n and 0 <= ny < n:
                if not copy_visited[nx][ny]:
                    if l <= abs(A[a][b] - A[nx][ny]) <= r:
                        copy_visited[nx][ny] = True
                        team.append([nx,ny])
                        sum += A[nx][ny]
                        q.append([nx,ny])
    cnt = len(team)

    for e in team:
        A[e[0]][e[1]] = sum // cnt

n, l, r = map(int, sys.stdin.readline().rsplit())
A = []
visited = []
answer = 0

for i in range(n):
    people = list(map(int, sys.stdin.readline().rsplit()))
    A.append(people)
    visited.append([False for _ in range(len(people))])

while True:
    copy_visited = deepcopy(visited)
    copy_A = deepcopy(A)

    for i in range(n):
        for j in range(n):
            if copy_visited[i][j] == False:
                bfs(i, j, copy_visited, [[i,j]], A[i][j])
    
    if A == copy_A:
        break

    answer += 1

print(answer)