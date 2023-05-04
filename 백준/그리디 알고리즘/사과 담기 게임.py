# 백준 2828번 - 사과 담기 게임

n, m = map(int, input().split())
start = [i+1 for i in range(m)]
move = 0
j = int(input())

for i in range(j):
    apple = int(input())

    if apple in start:
        continue
    else:
        while apple not in start:
            if apple < start[0]:
                start = list(map(lambda x: x-1, start))
            else:
                start = list(map(lambda x: x+1, start))
            move += 1
print(move)