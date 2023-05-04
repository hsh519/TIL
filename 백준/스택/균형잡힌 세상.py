# 백준 4949번 - 균형잡힌 세상

import sys

while True:
    s = sys.stdin.readline().rstrip()
    if s == '.':
        break

    l = []

    for e in s:
        if e == '(' or e == ')' or e == '[' or e == ']':
            l.append(e)

    while l.count(0) != len(l):
        for i in range(len(l)-1):
            if l[i] == 0:
                continue
            if (l[i] == '(' and l[i+1] == ')') or (l[i] == '[' and l[i+1] == ']'):
                l[i], l[i+1] = 0, 0
        if l.count(0) != 0:
            l = [e for e in l if e != 0]
        else:
            print('no')
            break
    else:
        print('yes')