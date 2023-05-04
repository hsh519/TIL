# 백준 1974번 - 스택 수열

import sys
from collections import deque

n = int(sys.stdin.readline())
l = deque([int(sys.stdin.readline()) for _ in range(n)])
stack = []
res = ""

for i in range(1,n+1):
    stack.append(i)
    res += '+\n'
    
    while stack[-1] == l[0]:
        res += '-\n'
        stack.pop()
        l.popleft()
        if not (stack and l):
            break
        
if len(l) == 0:
    print(res, end="")
else:
    print("NO")