import sys
n = int(sys.stdin.readline())
answer = 0

arr = [int(e) for e in sys.stdin.readline().rsplit()]
prefix_num = [arr[0]]
for i in range(1,len(arr)):
    prefix_num.append(arr[i] + prefix_num[i-1])


for i in range(len(arr)-1):
    answer += (arr[i] * (prefix_num[-1] - prefix_num[i]))

print(answer % 1000000007)