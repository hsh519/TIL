import sys

ls = []
checkes = [[0,1,2,3,4], [5,6,7,8,9], [10,11,12,13,14], [15,16,17,18,19], [20,21,22,23,24], [0,5,10,15,20], [1,6,11,16,21], [2,7,12,17,22], [3,8,13,18,23], [4,9,14,19,24], [0,6,12,18,24], [4,8,12,16,20]]
call = []
count = 0

for _ in range(5):
    ls.extend(list(map(int, sys.stdin.readline().rsplit())))

for _ in range(5):
    call.extend(list(map(int, sys.stdin.readline().rsplit())))

for e in call:
    hap = -1
    res = 0
    idx = ls.index(e)
    ls[idx] = 0
    count += 1

    if count >= 5:
        for check in checkes:
            a, b, c, d, e = check
            hap = ls[a] + ls[b] + ls[c] + ls[d] + ls[e]
            if hap == 0:
                res += 1
    if res >= 3:
        print(count)
        break