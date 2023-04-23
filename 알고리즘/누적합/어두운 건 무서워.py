import sys

r,c,q = map(int, sys.stdin.readline().rsplit())
arr = []

for i in range(r):
    arr.append([int(e) for e in sys.stdin.readline().rsplit()])

for i in range(r):
    for j in range(1, len(arr[i])):
        arr[i][j] = arr[i][j] + arr[i][j-1]

prefix_num = [[arr[0][i]] for i in range(c)]

for i in range(c):
    for j in range(1,r):
        prefix_num[i].append(arr[j][i] + prefix_num[i][j-1])

for _ in range(q):
    r1,c1,r2,c2 = map(int, sys.stdin.readline().rsplit())
    r1,c1,r2,c2 = r1-1, c1-1, r2-1, c2-1
    hap = 0
    if r1 == 0 and c1 == 0:
        hap = prefix_num[c2][r2]
    elif r1 == 0:
        hap = prefix_num[c2][r2] - prefix_num[c1-1][r2]
    elif c1 == 0:
        hap = prefix_num[c2][r2] - prefix_num[c2][r1-1]
    else:
        hap = prefix_num[c2][r2] - prefix_num[c2][r1-1] - (prefix_num[c1-1][r2] -prefix_num[c1-1][r1-1])
    print(hap//((c2-c1+1) * (r2-r1+1)))
