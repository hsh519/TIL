import sys

n = int(sys.stdin.readline())
ls = [0] * 68
ls[0] = 1
ls[1] = 1
ls[2] = 2
ls[3] = 4

for i in range(n):
    a = int(sys.stdin.readline())
    if a < 2:
        print(1)
    elif a == 2:
        print(2)
    elif a == 3:
        print(4)
    else:
        for j in range(4,a+1):
            if ls[j] != 0:
                continue
            ls[j] = ls[j-1] + ls[j-2] + ls[j-3] + ls[j-4]
        print(ls[a])