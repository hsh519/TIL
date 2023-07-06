import sys
from collections import deque

def bfs(start, end, count = 1):
    q = deque()
    q.append([start, count])

    while q:
        num, c = q.popleft()
        if num == end:
            print(c)
            break
        if num * 2 <= end:
            q.append([num * 2, c+1])
        if int(str(num) + '1') <= end:
            q.append([int(str(num) + '1'), c+1])
    else:
        print(-1)

a, b = map(int, sys.stdin.readline().rsplit())
bfs(a, b)