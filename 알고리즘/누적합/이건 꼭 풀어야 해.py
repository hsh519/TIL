import sys

a, n = map(int, sys.stdin.readline().split())
arr = [int(e) for e in sys.stdin.readline().split()]
arr.sort()

for i in range(1,len(arr)):
    arr[i] = arr[i] + arr[i-1]

for _ in range(n):
    l, r = map(int, sys.stdin.readline().split())
    if l == 1:
        print(arr[r-1])
    else:
        print(arr[r-1] - arr[l-2])