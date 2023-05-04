import sys

n = int(sys.stdin.readline())
cnt = 1
l, r = 0, 0

if n == 1:
    print("1/1")
else:
    while True:
        if n - cnt <= 0:
            break
        else:
            n -= cnt
        cnt += 1

    if cnt % 2 == 0:
        l, r = 1, cnt
        for _ in range(1,n):
            l += 1
            r -= 1
    else:
        l, r = cnt, 1
        for _ in range(1,n):
            l -= 1
            r += 1
    print(str(l)+'/'+str(r))