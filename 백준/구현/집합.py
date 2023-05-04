# 백준 11723번 - 집합

import sys

m = int(sys.stdin.readline())
s = set()

for i in range(m):
    c = sys.stdin.readline().rsplit()
    if 'add' in c:
        if int(c[1]) not in s:
            s.add(int(c[1]))

    elif 'remove' in c:
        if int(c[1]) in s:
            s.remove(int(c[1]))

    elif 'check' in c:
        if int(c[1]) in s:
            print(1)
        else:
            print(0)

    elif 'toggle' in c:
        if int(c[1]) in s:
            s.remove(int(c[1]))
        else:
            s.add(int(c[1]))

    elif 'all' in c:
        s = [i for i in range(1,21)]

    elif 'empty' in c:
        s = set()
    
