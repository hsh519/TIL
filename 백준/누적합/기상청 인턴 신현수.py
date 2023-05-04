import sys

n, k = map(int, sys.stdin.readline().split())
arr = [int(e) for e in sys.stdin.readline().split()]
ls = []
idx = 0

for i in range(1, len(arr)):
    arr[i] = arr[i] + arr[i-1]

while idx + k - 1 < len(arr):
    if idx == 0:
        ls.append(arr[idx+k-1])
    else:
        ls.append(arr[idx+k-1] - arr[idx-1])
    idx += 1

print(max(ls))