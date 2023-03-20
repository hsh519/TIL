# 백준 7568번 - 덩치

import sys

n = int(sys.stdin.readline())
l = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

for i in range(len(l)):
    count = 0
    for j in range(len(l)):
        if i == j:
            continue

        if l[i][0] < l[j][0] and l[i][1] < l[j][1]:
            count += 1
    print(count+1, end=" ")
