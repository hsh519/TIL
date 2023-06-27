import sys

def dfs(ls):

    for i in range(1, n+1):
        ls.append(i)
        if len(ls) >= m:
            print(*ls)
        else:
            dfs(ls)
        ls.pop()

n, m = map(int, sys.stdin.readline().rsplit())
for i in range(1, n+1):
    if m == 1:
        print(i)
    else:
        dfs([i])