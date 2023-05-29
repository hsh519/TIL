import sys
from collections import deque

t = int(sys.stdin.readline())

for _ in range(t):
    p = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline())
    x = sys.stdin.readline().rstrip()
    if x == '[]':
        x = deque()
    else:
        x = deque(map(int,x[1:-1].rsplit(',')))
    r = False
    check_error = True
    
    for c in p:
        if c == 'R':
            r = not r
        elif c == 'D':
            if x:
                if r:
                    deque.pop(x)
                else:
                    deque.popleft(x)
            else:
                print('error')
                check_error = False
                break
            
    if check_error:
        print('[', end="")
        while True:
            if not x:
                print(']')
                break

            if r:
                print(x.pop(), end="")
            else:
                print(x.popleft(), end="")

            if x:
                print(',', end="")
            else:
                print(']')
                break