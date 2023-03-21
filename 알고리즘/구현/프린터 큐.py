# 백준 1966번 - 프린터 큐

import sys
from collections import deque

for i in range(int(sys.stdin.readline())):
    n, search = map(int, sys.stdin.readline().split())
    l = deque([int(i) for i in sys.stdin.readline().split()])
    c, res = 0, 0

    while True:
        if max(l) == l[0]:
            l.popleft()
            res += 1
            if c == search:
                break
        else:
            l.append(l.popleft())
            if c == search:
                search += len(l)
        c += 1
    
    print(res)
            
