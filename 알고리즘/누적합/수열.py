import sys

n, k = map(int, sys.stdin.readline().split())
arr = [int(e) for e in sys.stdin.readline().split()]
idx, answer = 0, []

for i in range(1,n):
    arr[i] = arr[i] + arr[i-1]

while idx + k - 1 <= n-1:
    if idx == 0:
        answer.append(arr[idx+k-1])
    else:
        answer.append(arr[idx+k-1] - arr[idx-1])
    idx += 1
print(max(answer))