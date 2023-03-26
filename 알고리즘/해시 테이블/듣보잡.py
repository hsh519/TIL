# 백준 1764번 - 듣보잡

import sys

n, m = map(int, sys.stdin.readline().rsplit())
d1, d2, count, res = {}, {}, 0, ""

for _ in range(n):
    d1[sys.stdin.readline().rstrip()] = 0

for _ in range(m):
    d2[sys.stdin.readline().rstrip()] = 0

l = sorted(d1.keys())

for k in l:
    if k in d2.keys():
        count += 1
        res += k + "\n"
        
print(count)
print(res, end="")