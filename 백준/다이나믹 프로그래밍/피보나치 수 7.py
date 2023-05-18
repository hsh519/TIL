import sys

n = int(sys.stdin.readline())

if n == 0:
    print(0)
elif n == 1:
    print(1)
else:
    ls = [0,1]

    for i in range(2,n+1):
        num = ls[i-2]+ls[i-1]
        if num >= 1000000007:
            num = num % 1000000007
        ls.append(num)
    
    print(ls[-1])