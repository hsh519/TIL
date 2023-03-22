# 백준 1654번 - 랜선 자르기

import sys

n, k = map(int, sys.stdin.readline().split())
l1 = [int(sys.stdin.readline()) for _ in range(n)]
l2 = [i for i in range(min(l1) + 1)]
start = 0
end = len(l2) - 1
mid = (start + end) // 2

while True:
    count = list(map(lambda x: x//l2[mid], l1))
    if sum(count) == k:
        mid += 1
    elif sum(count) < k:
        if sum(list(map(lambda x: x//l2[mid-1], l1))) == k:
            mid -= 1
            break
        end = mid - 1
        mid = (start + end) // 2
    elif sum(count) > k:
        start = mid + 1
        mid = (start + end) // 2
print(mid)
