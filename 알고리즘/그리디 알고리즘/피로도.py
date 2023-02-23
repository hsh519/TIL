# 백준 22864번 - 피로도

a, b, c, m = input().split()
a, b, c, m = int(a), int(b), int(c), int(m)
count = 0
tired = 0

if(a > m):
    print(0)
else:
    for _ in range(24):
        if(tired + a <= m):
            count += 1
            tired += a
        else:
            tired -= c
            if tired < 0:
                tired = 0
    print(count * b)