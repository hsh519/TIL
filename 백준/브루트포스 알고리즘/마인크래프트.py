# 백준 18111번 - 마인크래프트

import sys
n ,m, b = map(int,sys.stdin.readline().split())
l = []
res_t, res_h = 500 * 500 * 255, 0

for _ in range(n):
    l.extend(int(i) for i in sys.stdin.readline().split())
for i in range(min(l), max(l)+1):
    need, count = b, 0
    for e in l:
        if e-i >= 0:
            count += 2 * (e-i)
        else:
            count += i-e
        need += e - i
    if need >= 0:
        if res_t > count or (res_t == count and res_h < i):
            res_t = count
            res_h = i

print(res_t, res_h)