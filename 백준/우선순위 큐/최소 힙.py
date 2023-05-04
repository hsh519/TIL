# 백준 1927번 - 최소 힙

import heapq
import sys

heap = []

for _ in range(int(sys.stdin.readline().rstrip())):
    i = int(sys.stdin.readline().rstrip())
    if(i == 0):
        if(not heap):
            print(0)
        else:
            min = heapq.heappop(heap)
            print(min)
    else:
        heapq.heappush(heap, i)
