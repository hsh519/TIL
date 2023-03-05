# 백준 1931번 - 회의실 배정

l = []
now, count = 0, 0

for i in range(int(input())):
    l.append(list(map(int, input().split())))

l.sort(key=lambda x: (x[1],x[0]))

for t in l:
    if now == 0:
        now = t[1]
        count += 1
    elif t[0] >= now:
        now = t[1]
        count += 1

print(count)
