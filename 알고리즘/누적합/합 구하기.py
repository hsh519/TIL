import sys

n = int(sys.stdin.readline())
arr = [int(e) for e in sys.stdin.readline().split()]

for i in range(1,len(arr)):
    arr[i] = arr[i] + arr[i-1]

m = int(sys.stdin.readline())

for _ in range(m):
    x,y = map(int, sys.stdin.readline().split())
    if x == 1:
        print(arr[y-1])
    else:
        print(arr[y-1] - arr[x-2])