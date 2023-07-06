import sys

n = int(sys.stdin.readline())
d = list(map(int, sys.stdin.readline().rsplit()))
m = list(map(int, sys.stdin.readline().rsplit()))
start = m[0]
answer = 0

for i in range(1, len(m)):
    answer += start * d[i-1]
    if i == n-1:
        break
    if start > m[i]:
        start = m[i]

print(answer)