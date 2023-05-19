import sys

n = int(sys.stdin.readline())
ls = [1,1,1]

if n <= 3:
    print(1)
else:
    for i in range(4,n+1):
        ls.append(ls[i-2]+ls[i-4])

    print(ls[-1])