# 백준 2108번 - 통계학

import sys
from collections import Counter

n = int(sys.stdin.readline())
l = [int(sys.stdin.readline()) for _ in range(n)]
count = Counter(l)
mode= count.most_common()
max_num = mode[0][1]
res = []
l.sort()

for e in mode:
    if max_num == e[1]:
        res.append(e[0])
res.sort()

print(round(sum(l) / n))
print(l[n//2])
if len(res) == 1:
    print(res[0])
else:
    print(res[1])
print(l[-1] - l[0])