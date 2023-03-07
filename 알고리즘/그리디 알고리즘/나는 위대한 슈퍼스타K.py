# 백준 2865번 - 나는 위대한 슈퍼스타K

n, m, k = map(int, input().split())
l = []
d = {}
res = 0

for i in range(m):
    l.extend(input().split())

for i in range(0, len(l), 2):
    key = l[i]
    if not d.get(key):
        d[key] = [float(l[i+1])]
    else:
        (d.get(key)).append(float(l[i+1]))

l.clear()

for v in d.values():
    l.append(max(v))

l.sort()

for i in range(k):
    res += l.pop()

print(round(res, 1))