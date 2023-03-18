# 백준 2775번 - 부녀회장이 될테야

import sys

for _ in range(int(sys.stdin.readline())):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    l = [i+1 for i in range(n)]
    res = [0 for _ in range(n)]

    for _ in range(k):
        for i in range(n):
            res[i] = sum(l[:i+1])
        l = res.copy()
    
    print(res[n-1])