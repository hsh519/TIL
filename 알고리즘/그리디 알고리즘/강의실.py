# 백준 1374번 - 강의실

import sys
import heapq

n = int(sys.stdin.readline())
study_list = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
res = []

study_list.sort(key= lambda x: x[1])


for study in study_list:
    if res and min(res) <= study[1]:
        heapq.heappop(res)
    heapq.heappush(res, study[2])
        
print(len(res))
