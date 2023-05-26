import sys

n = int(sys.stdin.readline())
ls = []
answer = 0

for i in range(n):
    a, b = map(int,sys.stdin.readline().rsplit())
    ls.append([a,a+9,b,b+9])


for i in range(101):
    for j in range(101):
        for e in ls:
            if e[0] <= j <= e[1] and e[2] <= i <= e[3]:
                answer += 1
                break

print(answer)