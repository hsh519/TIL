import sys

n = int(sys.stdin.readline())
ls = [1,1]
if n == 1:
    print(4)
else:
    for i in range(2,n+1):
        ls.append(ls[i-2] + ls[i-1])

    print(ls[-1] * 2 + ls[-2] * 2)