import sys

n, x = map(int, sys.stdin.readline().split())
arr = [int(e) for e in sys.stdin.readline().split()]
idx = 0
answer = 0
sum_list = []

for i in range(1, len(arr)):
    arr[i] = arr[i] + arr[i-1]

while idx+x-1 < len(arr):
    if idx == 0:
        sum_list.append(arr[idx+x-1])
        answer = max(answer, arr[idx+x-1])
    else:
        sum_list.append(arr[idx+x-1] - arr[idx-1])
        answer = max(answer, arr[idx+x-1] - arr[idx-1])
    idx += 1

if answer == 0:
    print('SAD')
else:
    print(answer)
    print(sum_list.count(answer))

