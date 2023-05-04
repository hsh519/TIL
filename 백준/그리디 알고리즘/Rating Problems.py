# 백준 21146번 - Rating Problems

n, k = input().split()
n, k = int(n), int(k)
res = 0

for _ in range(k):
    res += int(input())

max_avg = (res + (n-k) * 3) / n
min_avg = (res + (n-k) * -3) / n
print(min_avg, max_avg)