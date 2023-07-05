import sys

def dfs(start, x, y):
    for i in range(start+1, n):
        dx = int(x, 2) * int(ls[i][0], 2)
        dy = int(y, 2) + int(ls[i][1], 2)
        answer.append(abs(dx-dy))
        dfs(i, bin(dx), bin(dy))

n = int(sys.stdin.readline())
ls = []
answer = []

for i in range(n):
    s, b = map(int, sys.stdin.readline().rsplit())
    answer.append(abs(s-b))
    ls.append([bin(s), bin(b)])

for i in range(n):
    dfs(i, ls[i][0], ls[i][1])

print(min(answer))
