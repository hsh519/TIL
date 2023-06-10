import sys

n = int(sys.stdin.readline())
ls = list(map(int, sys.stdin.readline().rsplit()))
store = []

for i in range(len(ls)-1, 0, -1):
    store.append(ls[i])
    
    if ls[i] > ls[i-1]:
        continue
    else:
        store.append(ls[i-1])
        
        store.sort(reverse=True)
        idx = store.index(ls[i-1])+1
        ls[i-1] = store[idx]
        ls = ls[:i]
        del store[idx]
        break

if len(ls) == n:
    print(-1)
else:
    answer = ls + store
    print(*answer)