# 백준 11866번 - 요세푸스 문제 0

n, k = map(int, input().split())
l = [i+1 for i in range(n)]
res = []
idx = -1

while l != []:
    idx += k
    if idx >= len(l):
        idx = idx % len(l)
    res.append(l[idx])
    l.remove(l[idx])
    idx -= 1

print("<", end="")
print(*res, sep=", ", end="")
print(">", end="")

