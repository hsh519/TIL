# 백준 1654번 - 랜선 자르기

import sys

n, k = map(int, sys.stdin.readline().split())
l1 = [int(sys.stdin.readline()) for _ in range(n)]
start, res = 1, 0
end = max(l1)
mid = (start + end) // 2

while start <= end:
    count = sum(x//mid for x in l1)
    if count >= k:
        start = mid + 1
        mid = (start + end) // 2
    elif count < k:
        end = mid - 1
        mid = (start + end) // 2
        
print(mid)
