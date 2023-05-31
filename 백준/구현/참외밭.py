import sys
from collections import defaultdict

n = int(sys.stdin.readline())
ls = []
d = defaultdict(list)
line = [0,0]
answer = 1
count = 0

for i in range(6):
    a, b = map(int,sys.stdin.readline().rsplit())
    ls.append([a,b])

for e in ls:
    d[e[0]].extend(e)

for k in d:
    if len(d[k]) == 2:
        line[count] += d[k][1]
        answer *= d[k][1]
        if count == 0:
            count = 1
        else:
            count = 0
        idx = ls.index(d[k])
        if idx == 0:
            line[count] -= min(ls[-1][1], ls[1][1])
        elif idx == 5:
            line[count] -= min(ls[4][1], ls[0][1])
        else:
            line[count] -= min(ls[idx-1][1], ls[idx+1][1])

answer -= line[0] * line[1]
print(answer * n)