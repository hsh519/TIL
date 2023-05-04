# 백준 11651번 - 좌표 정렬하기 2

import sys

n = int(sys.stdin.readline())
l = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
l.sort(key=lambda x: (x[1], x[0]))

for e in l:
    print(*e)