import sys

# 풀이 1
n = int(sys.stdin.readline())

def count_res(ls):
    res = []
    for e in ls:
        n = 1
        for i in range(1,len(e)+1):
            n *= i
        for i in range(1, e.count(1)+1):
            n = n // i
        for i in range(1, e.count(2)+1):
            n = n // i
        for i in range(1, e.count(3)+1):
            n = n // i
        res.append(n)
    return sum(res)

d = {
    1: [[1,1,1,1]],
    2: [[2,1,1]],
    3: [[3,1]],
    4: [[2,2]],
    5: [[2,3]],
    6: [[2,2,2], [3,3]],
    7: [[3,2,2]],
    8: [[2,2,2,2], [3,3,2]],
    9: [[3,3,3], [2,2,2,3]],
    10: [[2,2,2,2,2], [3,3,2,2]]
}

ls = [1,2,4,7]
for i in range(5,11):
    answer = 0
    for k in range(1, i+1):
        if k != i:
            for j in range(len(d[k])):
                d[k][j].append(1)
        answer += count_res(d[k])
    ls.append(answer)

for i in range(n):
    a = int(sys.stdin.readline())
    print(ls[a-1])

# 풀이 2(dp)
n = int(sys.stdin.readline())
ls = [1,2,4,7]

for i in range(4,10):
    ls.append(ls[i-1] + ls[i-2] + ls[i-3])

for i in range(n):
    a = int(sys.stdin.readline())
    print(ls[a-1])