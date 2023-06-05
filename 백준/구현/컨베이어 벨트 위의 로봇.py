import sys
from collections import deque

n, k = map(int, sys.stdin.readline().rsplit())
ls = deque(list(map(int, sys.stdin.readline().rsplit())))
robot = deque([0] * (2*n))
answer = 1

while True:
    # 1
    ls.appendleft(ls.pop())
    robot.appendleft(robot.pop())
    robot[n-1] = 0

    # 2
    for i in range(n-2, -1, -1):
        if robot[i] == 1 and robot[i+1] == 0 and ls[i+1] > 0:
            if i == n-2:
                robot[i] = 0
            else:
                robot[i], robot[i+1] = 0, 1
            ls[i+1] -= 1
    # 3
    if ls[0] > 0:
        robot[0] = 1
        ls[0] -= 1

    # 4
    if ls.count(0) >= k:
        break

    answer += 1

print(answer)