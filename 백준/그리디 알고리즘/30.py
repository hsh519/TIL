import sys

s = sys.stdin.readline().rstrip()
ls = []

if '0' not in s:
    print(-1)
else:
    for c in s:
        ls.append(c)
    ls.remove('0')
    if int(''.join(ls)) % 3 == 0:
        ls.sort(reverse=True)
        ls.append('0')
        print(int(''.join(ls)))
    else:
        print(-1)