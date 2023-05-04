# 백준 18238번 - ZOAC 2

string = input()
alpha = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
start = 'A'
res = 0

for s in string:
    time = abs(alpha.index(start) - alpha.index(s))
    if abs(alpha.index(start) - alpha.index(s)) <= 13:
        res += time
    else:
        res += 26 - time
    start = s

print(res)