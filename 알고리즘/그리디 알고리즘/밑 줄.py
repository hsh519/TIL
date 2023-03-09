# 백준 1474번 - 밑 줄
n, m = map(int, input().split())
l = []

for i in range(n):
    s = input()
    m -= len(s)
    l.append(s)

print(m)
need, rest = m // (n-1), m % (n-1)
underbar = []
res = ''

for i in range(len(l)-1):
    if l[i+1][0].islower() and rest != 0:
        underbar.append('_' * (need + 1))
        rest -= 1
    else:
        underbar.append('_' * need)
else:
    for i in range(len(underbar)-1,-1,-1):
        if rest == 0:
            break
        if len(underbar[i]) == need + 1:
            continue
        else:
            underbar[i] = '_' * (need + 1)
            rest -= 1
            

for i in range(len(underbar)):
    res += l[i]
    res += underbar[i]

print(res+l[-1])


