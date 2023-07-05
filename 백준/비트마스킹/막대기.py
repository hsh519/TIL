import sys

n = int(sys.stdin.readline())
n = bin(n)
answer = 0

for i in range(2, len(n)):
    if n[i] == '1':
        answer += 1

print(answer)