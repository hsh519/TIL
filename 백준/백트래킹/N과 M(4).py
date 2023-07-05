import sys

def backtracking(ls):

    for i in range(1, n+1):
        ls.append(i)

        if ls[-1] < ls[-2]:
            ls.pop()
        else:
            if len(ls) < m:
                backtracking(ls)
                ls.pop()
            else:
                print(*ls)
                ls.pop()

n, m = map(int, sys.stdin.readline().rsplit())
for i in range(1, n+1):
    if m == 1:
        print(i)
        continue
    backtracking([i])
