# 백준 3135번 - 라디오

n = []
a, b = map(int, input().split())

for _ in range(int(input())):
    n.append(abs(b-int(input())))

if min(n) < abs(a-b):
    print(min(n)+1)
else:
    print(abs(a-b))