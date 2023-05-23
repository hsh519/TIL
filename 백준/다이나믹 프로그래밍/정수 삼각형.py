import sys

n = int(sys.stdin.readline())
ls = []
answer = 0

for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().rsplit())))

for i in range(n-1):
    j = len(ls[i])
    for k in range(j):
        if k == 0:
            ls[i+1][k] += ls[i][k]
        else:
            ls[i+1][k] = max(ls[i+1][k], ls[i+1][k] - ls[i][k-1] + ls[i][k])
        ls[i+1][k+1] += ls[i][k]

for i in range(n):
    answer = max(answer, max(ls[i]))

print(answer)