import sys

n = int(sys.stdin.readline())
ls = [0, 1]

if n == 0:
    print(0)
else:
    for i in range(2,n+1):
        ls.append(ls[i-2] + ls[i-1])

    print(ls[-1])