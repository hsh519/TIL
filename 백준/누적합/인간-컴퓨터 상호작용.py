import sys
from collections import OrderedDict

s = sys.stdin.readline().rstrip()
arr = []
d = OrderedDict()
for c in s:
    arr.append(c)

for k in set(arr):
    d[k] = [0 for _ in range(len(s))]

for i in range(len(arr)):
    d[arr[i]][i] = 1

for v in d.values():
    for i in range(1,len(v)):
        v[i] = v[i] + v[i-1]

for _ in range(int(sys.stdin.readline())):
    a, l, r = sys.stdin.readline().rstrip().rsplit()
    if a not in d.keys():
        sys.stdout.write(str(0) + '\n')
    else:
        if int(l) == 0:
            sys.stdout.write(str(d[a][int(r)]) + '\n')
        else:
            sys.stdout.write(str(d[a][int(r)] - d[a][int(l)-1])+'\n')