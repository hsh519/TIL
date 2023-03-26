# 백준 1620번 - 나는야 포켓몬 마스터 이다솜

import sys

n, m = map(int, sys.stdin.readline().rsplit())
d1, d2 = {}, {}
for i in range(n):
    s = sys.stdin.readline().rstrip()
    d1[i+1] = s
    d2[s] = i+1

for _ in range(m):
    s = sys.stdin.readline().rstrip()
    if s.isalpha():
        print(d2[s])
    else:
        print(d1[int(s)])
