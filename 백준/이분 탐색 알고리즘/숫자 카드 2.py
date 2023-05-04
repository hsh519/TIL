# 백준 10816번 - 숫자 카드 2

import sys
from bisect import bisect_left, bisect_right

n = sys.stdin.readline()
nl = [int(i) for i in sys.stdin.readline().split()]
nl.sort()
m = sys.stdin.readline()
ml = [int(i) for i in sys.stdin.readline().split()]

for i in ml:
    l = bisect_left(nl, i)
    r = bisect_right(nl, i)
    print(r-l, end=" ")