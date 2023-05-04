# 백준 2847번 - 게임을 만든 동준이
scores = []
res = 0

for i in range(int(input())):
    scores.append(int(input()))
    
n = scores[-1]

for i in range(len(scores)-1,-1,-1):
    if n == scores[i]:
        n -= 1
    elif n < scores[i]:
        res += scores[i] - n
        n -= 1
    else:
        n = scores[i] - 1
        
print(res)
