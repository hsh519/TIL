import sys

n = int(sys.stdin.readline())
ls = []

for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().rsplit())))


for i in range(1,n):
    ls[i][0] = min(ls[i-1][1], ls[i-1][2]) + ls[i][0]
    ls[i][1] = min(ls[i-1][0], ls[i-1][2]) + ls[i][1]
    ls[i][2] = min(ls[i-1][0], ls[i-1][1]) + ls[i][2]

print(min(ls[n-1]))