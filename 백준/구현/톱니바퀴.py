import sys
from collections import deque

store = []
ls = deque()
ls.append(deque())
ls.append(deque())
ls.append(deque())
ls.append(deque())
answer = 0

def bfs(start, turn):
    q = deque()
    q.append(start)
    visited = [False] * 4
    visited[start[0]] = True

    d = [1, -1]

    while q:
        now, direct = q.popleft()

        for i in range(2):
            nx = now + d[i]

            if 0 <= nx < 4:
                if visited[nx] == False:
                    if now+1 == nx:
                        if ls[now][2] != ls[nx][6]:
                            visited[nx] = True
                            if direct == 1:
                                turn.append([nx, -1])
                                q.append([nx, -1])
                            else:
                                turn.append([nx, 1])
                                q.append([nx, 1])
                    else:
                        if ls[now][6] != ls[nx][2]:
                            visited[nx] = True
                            if direct == 1:
                                turn.append([nx, -1])
                                q.append([nx, -1])
                            else:
                                turn.append([nx, 1])
                                q.append([nx, 1])

for i in range(4):
    store.append(sys.stdin.readline().rstrip())

for i in range(len(store)):
    for c in store[i]:
        ls[i].append(int(c))

n = int(sys.stdin.readline())
for i in range(n):
    a, b = map(int,sys.stdin.readline().rsplit())
    turn = [[a-1, b]]

    bfs([a-1,b], turn)

    for e in turn:
        if e[1] == 1:
            num = ls[e[0]].pop()
            ls[e[0]].appendleft(num)
        else:
            num = ls[e[0]].popleft()
            ls[e[0]].append(num)

for i in range(4):
    if i == 0 and ls[i][0] == 1:
        answer += 1

    if i == 1 and ls[i][0] == 1:
        answer += 2

    if i == 2 and ls[i][0] == 1:
        answer += 4

    if i == 3 and ls[i][0] == 1:
        answer += 8

print(answer)