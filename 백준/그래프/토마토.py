import sys
from collections import deque

def bfs(n, m, answer):
    next = [0, 0]
    
    d = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    q = deque()
    
    for i in range(m):
        for j in range(n):
            if box[i][j] == 1:
                next[1] += 1
                visited[i][j] = True
                q.append([i,j])

    while q:
        now = q.popleft()
        if answer + 1 == len(next):
            next.append(0)
        next[answer] -= 1
        for i in range(4):
            nx = now[0] + d[i][0]
            ny = now[1] + d[i][1]

            if 0 <= nx < m and 0 <= ny < n:
                if not visited[nx][ny] and box[nx][ny] != -1:
                    next[-1] += 1
                    visited[nx][ny] = True
                    box[nx][ny] = 1
                    q.append([nx, ny])
    
        if next[answer] == 0:
            answer += 1       
    
    return answer
    
n, m = map(int, sys.stdin.readline().rsplit())
box = []
visited = [[False] * n for _ in range(m)]
answer = 1

for _ in range(m):
    box.append(list(map(int, sys.stdin.readline().rsplit())))

answer = bfs(n, m, answer)

for b in box:
    if 0 in b:
        print(-1)
        break
else:
    print(answer-2)