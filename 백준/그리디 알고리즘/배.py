from collections import deque

l = deque()
count = 0

for i in range(int(input())):
    n = int(input())
    if n != 1:
        l.append(n)

while len(l) != 0:
    n = l[0]
    term = n-1
    l = [e for e in l if (e-n) % term != 0]
    count += 1

print(count)