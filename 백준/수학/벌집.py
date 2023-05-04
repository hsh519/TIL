# 백준 2292번 - 벌집

n = int(input())
count, res = 1, 0

while True:
    res += 1
    if 6*(res-1) + count < n:
        count = 6*(res-1) + count
    else:
        print(res)
        break