import sys

n = int(sys.stdin.readline())
standard = 10
cnt = 1
answer = 0

while True:
    if standard > n:
        answer += (n - (standard//10) + 1) * cnt
        break
    else:
        answer += 9 * (standard//10) * cnt
        cnt += 1
        standard *= 10

print(answer)