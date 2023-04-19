import sys

arr = []
gap = 100
idx = 0

for _ in range(10):
    arr.append(int(sys.stdin.readline()))

for i in range(1,len(arr)):
    arr[i] = arr[i] + arr[i-1]

for i in range(len(arr)):
    if abs(100 - arr[i]) <= gap:
        gap = 100 - arr[i]
        idx = i

print(arr[idx])
