import sys

n,k = map(int, sys.stdin.readline().rsplit())
arr = []
idx = 0
answer = 0
for i in range(n):
    g, x = map(int, sys.stdin.readline().rsplit())
    arr.append([g,x])
arr.sort(key=lambda x: x[1])

prefix_num = [0 for _ in range(arr[-1][-1]+1)]

for ls in arr:
    prefix_num[ls[1]] = ls[0]

for i in range(1,len(prefix_num)):
    prefix_num[i] = prefix_num[i] + prefix_num[i-1]

for idx in range(len(prefix_num)):
    left, right = idx - k, idx + k
    if left < 0:
        left = 0
    if right >= len(prefix_num):
        right = len(prefix_num)-1
    
    if left == 0:
        answer = max(answer, prefix_num[right])
    else:
        answer = max(answer, prefix_num[right] - prefix_num[left - 1])
print(answer)