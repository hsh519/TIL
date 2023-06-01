import sys

ls = []
answer = 0

for i in range(4):
    ls.append(list(map(int, sys.stdin.readline().rsplit())))
    
for i in range(1,101):
    for j in range(1,101):
        for k in range(4):
            if ls[k][0] <= j < ls[k][2] and ls[k][1] <= i < ls[k][3]:
                answer += 1
                break

print(answer)