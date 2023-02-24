# 백준 21313번 - 문어

n = int(input())
res = []

for _ in range(n//2):
    res.append(1)
    res.append(2)

if n%2 != 0:
    res.append(3)

print(*res, sep=" ")
