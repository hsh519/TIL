import sys

def check_eat_max_candy(start):
    x, y = start
    d = [[-1,0], [0, 1], [1, 0], [0, -1]]
    
    for i in range(4):
        nx = x + d[i][0]
        ny = y + d[i][1]
        
        if 0 <= nx < n and 0 <= ny < n:
            if ls[x][y] == ls[nx][ny]:
                continue
            ls[x][y], ls[nx][ny] = ls[nx][ny], ls[x][y]
            res1, res2, res3 = [1], [1], [1]
            if i == 1 or i == 3:
                for i in range(1,n):
                    if ls[i][y] == ls[i-1][y]:
                        res1[-1] += 1
                    else:
                        res1.append(1)
                    
                    if ls[i][ny] == ls[i-1][ny]:
                        res2[-1] += 1
                    else:
                        res2.append(1)
                    
                    if ls[x][i] == ls[x][i-1]:
                        res3[-1] += 1
                    else:
                        res3.append(1)
                    
            else:
                for i in range(1,n):
                    if ls[x][i] == ls[x][i-1]:
                        res1[-1] += 1
                    else:
                        res1.append(1)
                    
                    if ls[nx][i] == ls[nx][i-1]:
                        res2[-1] += 1
                    else:
                        res2.append(1)

                    if ls[i][y] == ls[i-1][y]:
                        res3[-1] += 1
                    else:
                        res3.append(1)
            answer.append(max(res1))
            answer.append(max(res2))
            answer.append(max(res3))
            ls[x][y], ls[nx][ny] = ls[nx][ny], ls[x][y]

def check_candy(start):
    x, y = start
    res1, res2 = [1], [1]
    for i in range(1,n):
        if ls[i][y] == ls[i-1][y]:
            res1[-1] += 1
        else:
            res1.append(1)
        
        if ls[x][i] == ls[x][i-1]:
            res2[-1] += 1
        else:
            res2.append(1)
        answer.append(max(res1))
        answer.append(max(res2))

n = int(sys.stdin.readline())
store = []
ls = []
answer = []

for i in range(n):
    store.append(sys.stdin.readline().rstrip())

for s in store:
    res = []
    for c in s:
        res.append(c)
    ls.append(res)
        
for i in range(n):
    if n in answer:
        print(n)
        break
    for j in range(n):
        check_candy([i,j])
        check_eat_max_candy([i,j])
else:
    print(max(answer))

