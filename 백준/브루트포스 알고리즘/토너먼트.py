import sys

n, k, i = map(int, sys.stdin.readline().rsplit())
ls = [0] * n
ls[k-1], ls[i-1] = 1, 1
b = True
answer = 1

while b:
    res = []
    if len(ls) % 2 != 0:
        for i in range(0, len(ls)-1, 2):
            if ls[i] == 0 and ls[i+1] == 0:
                res.append(0)
            elif (ls[i] == 0 and ls[i+1] == 1) or (ls[i] == 1 and ls[i+1] == 0):
                res.append(1)
            else:
                b = False
                break
        else:
            answer += 1

        res.append(ls[-1])
    else:
        for i in range(0, len(ls), 2):
            if ls[i] == 0 and ls[i+1] == 0:
                res.append(0)
            elif (ls[i] == 0 and ls[i+1] == 1) or (ls[i] == 1 and ls[i+1] == 0):
                res.append(1)
            else:
                b = False
                break
        else:
            answer += 1
    
    ls = res

print(answer)
