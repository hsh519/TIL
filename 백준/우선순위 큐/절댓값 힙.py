import heapq, sys

heap = []

for _ in range(int(sys.stdin.readline().rstrip())):
    i = int(sys.stdin.readline().rstrip())

    if(i == 0):
        if(not heap):
            print(0)
        else:
            res = heapq.heappop(heap)
            print(res[1])
    else:
        heapq.heappush(heap, (abs(i), i))