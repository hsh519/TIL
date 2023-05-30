import sys

an, am = map(int, sys.stdin.readline().rsplit())
als = []

for i in range(an):
    als.append(list(map(int, sys.stdin.readline().rsplit())))

bn, bm = map(int, sys.stdin.readline().rsplit())
bls = []
ls = []

for i in range(bn):
    bls.append(list(map(int, sys.stdin.readline().rsplit())))

for i in range(len(bls[0])):
    res = []
    for j in range(len(bls)):
        res.append(bls[j][i])
    ls.append(res)

for i in range(len(als)):
    for j in range(len(ls)):
        res = 0
        for k in range(len(als[0])):
            res += als[i][k] * ls[j][k]
        print(res, end=" ")
    print()
    