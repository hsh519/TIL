# 백준 2869번 - 달팽이는 올라가고 싶다

import sys
import math

a, b, v = map(int, sys.stdin.readline().split())
v -= a
if v == 0:
    print(1)
elif v < a-b:
    print(2)
else:
    count = math.ceil(v / (a-b)) + 1
    print(count)