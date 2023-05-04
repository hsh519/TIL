
from operator import indexOf

import sys

l, r = map(int, sys.stdin.readline().split())
d = {}
# 백준 1105번 - 팔

for i in range(l, r+1):
    c = str(i).count("8")
    if not d.get(c):
        d[c] = 1
    else:
        d[c] += 1
    
    if c==0:
        break

print(min(list(d.keys())))