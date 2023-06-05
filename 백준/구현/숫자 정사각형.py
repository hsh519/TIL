import sys

n, m = map(int, sys.stdin.readline().rsplit())
store = []
ls = []
answer = 1

for _ in range(n):
    store.append(sys.stdin.readline().rstrip())

for s in store:
    res = []
    for c in s:
        res.append(int(c))
    ls.append(res)

for i in range(n):
    for j in range(m):
        for k in range(n):
            if i+k < n and j+k < m:
                if ls[i][j] == ls[i+k][j] == ls[i][j+k] == ls[i+k][j+k]:
                    answer = max((k+1) * (k+1), answer)
    if answer == n * n:
        break

print(answer)