import sys

n, m = map(int, sys.stdin.readline().rsplit())
arr = [int(e) for e in sys.stdin.readline().rsplit()]
idx, answer = 0, 0

for i in range(1, len(arr)):
    arr[i] += arr[i-1]

while idx + m - 1< len(arr):
    if idx == 0:
        answer = max(answer, arr[idx+m-1])
    else:
        answer = max(answer, arr[idx+m-1] - arr[idx-1])
    idx += 1

print(answer)