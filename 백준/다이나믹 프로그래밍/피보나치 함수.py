# 백준 1003번 - 피보나치 함수

import sys
for i in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())

    if n == 0:
        print("1 0")
    elif n == 1:
        print("0 1")
    else:
        d = {}
        for i in range(n+1):
            if i == n:
                d[i] = 1
            else:
                d[i] = 0
        s = sorted(d.keys(), reverse=True)
        for i in s:
            if i >= 2:
                d[i-1] += d[i]
                d[i-2] += d[i]
        print(d[0], d[1])