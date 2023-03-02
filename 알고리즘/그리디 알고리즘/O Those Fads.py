# 백준 6123번 - O Those Fads

n, l, k = map(int, input().split())
cows = []
count = 0
switch = True

for i in range(n):
    cows.append(int(input()))

while switch:
    for cow in cows:
        if l >= cow:
            cows.remove(cow)
            l += k
            count += 1
            break
    else:
        switch = False

print(count)
