import sys
from itertools import combinations
        
n, m = map(int, sys.stdin.readline().rsplit())
ls = []
chicken_list = []
house_list = []
distance = []
answer = []

for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().rsplit())))

for i in range(n):
    for j in range(n):
        if ls[i][j] == 2:
            chicken_list.append([i,j])
        if ls[i][j] == 1:
            house_list.append([i,j])

for c in chicken_list:
    res = []
    for h in house_list:
        res.append(abs(h[0] - c[0]) + abs(h[1] - c[1]))
    distance.append(res)

ls = list(combinations(chicken_list, m))

for i in range(len(ls)):
    res = 0
    for j in range(len(house_list)):
        num = 101
        for k in range(len(ls[i])):
            idx = chicken_list.index(ls[i][k])
            num = min(distance[idx][j], num)
        res += num
    answer.append(res)

print(min(answer))