import sys

n = int(sys.stdin.readline())
answer = [1,2]

if n == 1:
    print(1)
elif n == 2:
    print(2)
else:
    for i in range(2,n):
        res = answer[i-2] + answer[i-1]
        if res >= 10007:
            res %= 10007
        answer.append(res)

    print(answer[-1])