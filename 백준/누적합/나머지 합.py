import sys

n, m = map(int, sys.stdin.readline().rsplit())
ls = list(map(int, sys.stdin.readline().rsplit()))
num = 0
rest = [0] * m

for i in range(len(ls)):
    num += ls[i]
    rest[num % m] += 1

answer = rest[0]

for e in rest:
    answer += e*(e-1) // 2

print(answer)