# 백준 10814번 - 나이순 정렬

import sys

l = []

for _ in range(int(sys.stdin.readline())):
    l.append(sys.stdin.readline().split())

l.sort(key=lambda x: int(x[0]))

for i in l:
    print(*i)