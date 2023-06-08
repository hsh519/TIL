import sys

ls = []

for i in range(1,10):
    for j in range(1,10):
        if i == j:
            continue
        for k in range(1,10):
            if i == k or j == k:
                continue
            ls.append(str(i) + str(j) + str(k))

n = int(sys.stdin.readline())

for i in range(n):
    num, s, b = map(int, sys.stdin.readline().rsplit())
    num = str(num)
    if s == 3:
        print(1)
        break

    for j in range(len(ls)):
        strike, ball = 0, 0
        if ls[j] == '0':
            continue

        if ls[j][0] == num[0]:
            strike += 1
        if ls[j][1] == num[1]:
            strike += 1
        if ls[j][2] == num[2]:
            strike += 1
        
        ball = num.count(ls[j][0]) + num.count(ls[j][1]) + num.count(ls[j][2]) - strike

        if strike != s or ball != b:
            ls[j] = '0'

ls = list(filter(lambda x: x != '0', ls))
print(len(ls))