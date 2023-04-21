import sys
n, k, b = map(int, sys.stdin.readline().split())
arr = [1 for _ in range(n)]
idx, answer = 0, b

for _ in range(b):
    wrong = int(sys.stdin.readline())
    arr[wrong-1] = 0

for i in range(1, len(arr)):
    arr[i] = arr[i] + arr[i-1]

while idx + k - 1 < len(arr):
    if idx == 0:
        answer = min(answer,  k - arr[idx + k - 1])
    else:
        answer = min(answer, k - (arr[idx + k - 1] - arr[idx - 1]))
    idx += 1

print(answer)