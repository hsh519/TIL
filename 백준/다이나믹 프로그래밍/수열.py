import sys

n = int(sys.stdin.readline())
k = list(map(int, sys.stdin.readline().rsplit()))
up_answer = [1]
down_answer = [1]

for i in range(1,n):
    if k[i-1] == k[i]:
        up_answer.append(up_answer[i-1]+1)
        down_answer.append(down_answer[i-1]+1)
        continue

    if k[i-1] < k[i]:
        up_answer.append(up_answer[i-1]+1)
        down_answer.append(1)
    if k[i-1] > k[i]:
        down_answer.append(down_answer[i-1]+1)
        up_answer.append(1)

print(max(max(up_answer), max(down_answer)))