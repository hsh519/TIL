import sys
n, m = map(int, sys.stdin.readline().split())
arr = [int(e) for e in sys.stdin.readline().split()]

for i in range(1,n):
    arr[i] = arr[i] + arr[i-1]

for _ in range(m):
    i,j = map(int, sys.stdin.readline().split())
    if i == 1:
        print(arr[j-1])
    else:
        print(arr[j-1] - arr[i-2])