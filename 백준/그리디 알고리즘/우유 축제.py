# 백준 14720번 - 우유 축제

n = int(input())
stores = list(map(int, input().split()))
turn, count = 0, 0

for store in stores:
    if turn == store:
        count += 1
        turn = (turn+1) % 3

print(count)