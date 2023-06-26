import sys

n = int(sys.stdin.readline())
tmp = 0
answer = 0

for i in range(1,n+1):
    s = str(i)
    for j in range(len(s)-1):
        if j == 0:
            tmp = int(s[j]) - int(s[j+1])
        elif tmp != int(s[j]) - int(s[j+1]):
            break
    else:
        answer += 1

print(answer)