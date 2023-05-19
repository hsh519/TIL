import sys

n = int(sys.stdin.readline())
answer = 0

if n == 1:
    print(answer)
else:
    for i in range(1,n):
        answer += i
    print(answer)