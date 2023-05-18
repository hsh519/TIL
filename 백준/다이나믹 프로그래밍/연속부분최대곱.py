import sys

n = int(sys.stdin.readline())
ls = []
answer = 0

for i in range(n):
    f = float(sys.stdin.readline())
    ls.append(f)
    if i == 0:
        answer = f
    else:
        answer = max(answer * f, f)
        ls.append(answer)
        
print("%.3f" % max(ls))