# 백준 10866번 - 덱

from collections import deque
import sys

l = deque()
for _ in range(int(sys.stdin.readline())):
    s = sys.stdin.readline().split()

    if s[0] == 'push_front':
        l.appendleft(int(s[1]))
    
    elif s[0] == 'push_back':
        l.append(int(s[1]))
    
    elif s[0] == 'pop_front':
        if len(l) == 0:
            print(-1)
        else:
            print(l.popleft())
    
    elif s[0] == 'pop_back':
        if len(l) == 0:
            print(-1)
        else:
            print(l.pop())
    
    elif s[0] == 'size':
        print(len(l))
    
    elif s[0] == 'empty':
        if len(l) == 0:
            print(1)
        else:
            print(0)

    elif s[0]== 'front':
        if len(l) == 0:
            print(-1)
        else:
            print(l[0])
    
    elif s[0] == 'back':
        if len(l) == 0:
            print(-1)
        else:
            print(l[-1])