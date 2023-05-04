# 백준 14916번 - 거스름돈

n = int(input())
five_count = n // 5
rest = n % 5

while rest % 2 != 0:
    rest += 5
    five_count -= 1

    if five_count < 0:
        break

if five_count < 0:
    print(-1)
else:
    print(five_count + rest // 2)