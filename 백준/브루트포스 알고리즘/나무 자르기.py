# 백준 2805번 - 나무 자르기

import sys

n, m = map(int, sys.stdin.readline().split())
l1 = [int(i) for i in sys.stdin.readline().split()]
start, end = 1, max(l1)
mid = (start + end) // 2

while start <= end:
    count = sum(i-mid if i-mid > 0 else 0 for i in l1)
    if count >= m:
        start = mid + 1
    else:
        end = mid - 1
    mid = (start + end) // 2
print(mid)