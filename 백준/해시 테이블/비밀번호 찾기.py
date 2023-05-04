# 백준 17129번 - 비밀번호 찾기

import sys

n, m = map(int, sys.stdin.readline().rsplit())
d = {}

for _ in range(n):
    k, v = sys.stdin.readline().rstrip().rsplit()
    d[k] = v
    
for _ in range(m):
    k = sys.stdin.readline().rstrip()
    print(d[k])