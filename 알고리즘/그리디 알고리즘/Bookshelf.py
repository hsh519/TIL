# 백준 6147번 - Bookshelf

n, s = map(int, input().split())
cows = []
count = 0

for i in range(n):
    cows.append(int(input()))

cows.sort(reverse=True)

for cow in cows:
    s -= cow
    count += 1

    if s <= 0:
        break
    
print(count)