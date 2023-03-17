# 백준 1920번 - 수 찾기
import sys

n = int(sys.stdin.readline())
nl = [int(i) for i in sys.stdin.readline().split()]
nl.sort()
m = int(sys.stdin.readline())
ml = [int(i) for i in sys.stdin.readline().split()]

for i in range(len(ml)):
    start = 0
    end = len(nl)-1
    mid = (start+end) // 2
    while True:
        if start > end:
            print(0)
            break

        if ml[i] == nl[mid]:
            print(1)
            break
        elif ml[i] > nl[mid]:
            start = mid + 1
            mid = (start+end) // 2
        else:
            end = mid - 1
            mid = (start+end) // 2
