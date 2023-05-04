# 백준 11279번 - 최대 힙

import sys
import heapq

heap = []

for _ in range(int(sys.stdin.readline().rstrip())):
    i = int(sys.stdin.readline().rstrip())

    if(i == 0):
        if(not heap):
            print(0)
        else:
            max = 0 - heapq.heappop(heap)
            print(max)
    else:
        heapq.heappush(heap, 0-i)