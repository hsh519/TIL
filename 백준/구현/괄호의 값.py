import sys

s = sys.stdin.readline().rstrip()
stack = []
ls = []
deep = 0

for c in s:
    if not stack:
        stack.append(c)
        deep += 1
        continue

    if stack[-1] == '(' and c == ')':
        ls.append([deep, 2])
        stack.pop()
        deep -= 1
    elif stack[-1] == '[' and c == ']':
        ls.append([deep, 3])
        stack.pop()
        deep -= 1
    else:
        stack.append(c)
        deep += 1

if stack:
    print(0)
else:
    for e in ls:
        deep = max(deep, e[0])

    while True:
        for i in range(len(ls)-1):
            if deep == ls[i][0]:
                if ls[i][0] > ls[i+1][0]:
                    ls[i][0] = ls[i+1][0]
                    ls[i][1] = ls[i][1] * ls[i+1][1]
                    del ls[i+1]
                    break
                elif ls[i][0] == ls[i+1][0]:
                    ls[i][1] += ls[i+1][1]
                    del ls[i+1]
                    break
        else:
            deep -= 1
        
        if len(ls) == 1:
            break

    print(ls[0][1])