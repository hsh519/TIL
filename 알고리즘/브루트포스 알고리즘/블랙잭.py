# 백준 2798번 - 블랙잭

n, m = map(int, input().split())
l = list(map(int, input().split()))
res = [m]

for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            res.append(l[i] + l[j] + l[k])
res.sort()
idx = res.index(m)

if res.count(m) >= 2:
    print(m)
else:
    print(res[idx-1])