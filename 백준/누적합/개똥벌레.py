import sys
from bisect import bisect_left

n, m = map(int, sys.stdin.readline().rsplit())
h_s, h_j = [], []
ls = []

for i in range(n):
    if i == 0 or i % 2 == 0:
        h_s.append(int(sys.stdin.readline()))
    else:
        h_j.append(int(sys.stdin.readline()))
    
h_s.sort()
h_j.sort()

for i in range(1,m+1):
    idx_s = len(h_s) - bisect_left(h_s, i)
    idx_j = len(h_j) - bisect_left(h_j, m-i+1)
    ls.append(idx_s + idx_j)

print(min(ls), ls.count(min(ls)))