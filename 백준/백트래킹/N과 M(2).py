import sys

def for_cycle(count, res = "", start = 1):
    for i in range(start,count):
        res += str(i)
        if count == n+1:
            answer.append(res)
            res = res[:-1]
        else:
            for_cycle(count+1, res, i+1)
            res = res[:-1]


n, m = map(int,sys.stdin.readline().rsplit())
c = n-m+2
answer = []

for_cycle(c)
for s in answer:
    print(" ".join(s))