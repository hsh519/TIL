import sys

n, k = map(int, sys.stdin.readline().rsplit())
ls = [0,0]

for i in range(2, n+1):
    ls.append(i)

for i in range(2,n+1):
    if ls[i] == 0:
        continue
    
    k -= 1
    if k == 0:
        print(ls[i])
    else:
        for j in range(i+i, n+1, i):
            if ls[j] == 0:
                continue
            
            k -= 1
            if k == 0:
                print(ls[j])
            else:
                ls[j] = 0