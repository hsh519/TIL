import sys

n = int(sys.stdin.readline())
ls = [1,1,2,5]
cnt = 4

if n == 0:
    print(1)
elif n == 1:
    print(1)
elif n == 2:
    print(2)
elif n == 3:
    print(5) 
else:
    for i in range(n-3):
        res = 0
        for j in range(cnt):
            res += ls[j]*ls[cnt-j-1]
        ls.append(res)
        cnt += 1
        
    print(ls[-1])