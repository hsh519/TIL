# 백준 1263번 - 시간 관리
l = []
time = 0
sw = True

for i in range(int(input())):
    l.append(list(map(int, input().split())))

l.sort(key= lambda x: x[1])

while sw:
    e = time
    for i in l:
        e += i[0]
        if e > i[1]:
            sw = False
            break
    else:
        time += 1

print(time-1)
