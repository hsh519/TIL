# 백준 2231번 - 분해합

n = int(input())

for i in range(n):
    s = str(i)
    l = [int(j) for j in s]
    if n == i + sum(l):
        print(i)
        break
else:
    print(0)