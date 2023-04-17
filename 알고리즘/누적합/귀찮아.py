import sys

n = int(sys.stdin.readline())
arr = [int(e) for e in sys.stdin.readline().split()]
prefix_sum = [arr[0]]
answer = 0

for i in range(1, len(arr)):
    prefix_sum.append(arr[i] + prefix_sum[i-1])

for i in range(len(arr)-1):
   answer += arr[i] * (prefix_sum[-1] - prefix_sum[i])

print(answer)