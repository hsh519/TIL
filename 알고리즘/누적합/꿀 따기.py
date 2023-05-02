import sys

n = int(sys.stdin.readline())
arr = [int(e) for e in sys.stdin.readline().rsplit()]
prefix_num = [arr[0]]
answer = 0

for i in range(1, len(arr)):
    prefix_num.append(arr[i] + prefix_num[i-1])

for i in range(1,len(arr)-1):
    answer = max(answer, prefix_num[-1] - prefix_num[0] + prefix_num[-1] - prefix_num[i] - arr[i])

for i in range(1-len(arr), -1):
    answer = max(answer, prefix_num[-2] + prefix_num[i-1] - arr[i])

for i in range(1, len(arr)-1):
    answer = max(answer,prefix_num[i] - prefix_num[0] + prefix_num[-2] - prefix_num[i-1])
print(answer)