import sys

n, k = map(int, sys.stdin.readline().rsplit())
ls = [1, [1,1]]

if n == 1 and k == 1:
    print(1)
else:
    for i in range(2, n):
        store= []
        store.append(1)
        for j in range(len(ls[i-1])-1):
            store.append(ls[i-1][j] + ls[i-1][j+1])
        store.append(1)
        ls.append(store)

    print(ls[n-1][k-1])