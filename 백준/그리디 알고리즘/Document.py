# 백준 11822번 - Document

n = int(input())
start = 0
count = 0

for i in range(n):
    l = list(map(int, input().split()))
    count += 1
    while l[start%5] != 1:
        start = count
        count += 1
        
    start = count
if start%5 == 0:
    print(count + (start//5 - 1) * 2)
else:
    print(count + (start//5) * 2)
