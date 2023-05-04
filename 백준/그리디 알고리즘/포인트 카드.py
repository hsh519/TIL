# 백준 14471번 - 포인트 카드

n, m = map(int, input().split())
win = 0
need_money_list = []
res = 0

for _ in range(m):
    t, f = map(int, input().split())

    if t >= n:
        win += 1
    else:
        need_money_list.append(n - t)

if m-1 <= win:
    print(0)
else:
    for _ in range(m-1-win):
        num = min(need_money_list)
        res += num
        need_money_list.remove(num)
    print(res)