# 백준 6032번 - Toy Shopping

hfm = []
jp_list = []
res = [0]

for i in range(int(input())):
    j, p = map(int, input().split())
    jp_list.append([j,p])
    hfm.append(j/p)

for i in range(3):
    idx = hfm.index(max(hfm))
    res[0] += jp_list[idx][1]
    res.append(idx+1)
    hfm[idx] = 0

print(res[0])
print(res[1])
print(res[2])
print(res[3])
