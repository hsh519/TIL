# 백준 11650번 - 좌표 정렬하기

l = []

for i in range(int(input())):
    l.append(list(map(int, input().split())))

l.sort(key=lambda x: (x[0], x[1]))

for e in l:
    print(*e, sep=" ")