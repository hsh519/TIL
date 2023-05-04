import sys

n, m = map(int, sys.stdin.readline().rsplit())
c, r, d = map(int, sys.stdin.readline().rsplit())
arr = []
answer = 0

for i in range(n):
    arr.append([int(e) for e in sys.stdin.readline().rsplit()])

while True:
    if arr[c][r] == 0:
        answer += 1
        arr[c][r] = 2
    if arr[c-1][r] != 0 and arr[c+1][r] != 0 and arr[c][r-1] != 0 and arr[c][r+1] != 0:
        if d == 0 and arr[c+1][r] != 1:
            c += 1
        elif d == 1 and arr[c][r-1] != 1:
            r -= 1
        elif d == 2 and arr[c-1][r] != 1:
            c -= 1
        elif d == 3 and arr[c][r+1] != 1:
            r += 1
        else:
            break
    else:
        if d == 0:
            d = 3
        else:
            d -= 1
        if d == 0 and arr[c-1][r] == 0:
            c -= 1
        elif d == 1 and arr[c][r+1] == 0:
            r += 1
        elif d == 2 and arr[c+1][r] == 0:
            c += 1
        elif d == 3 and arr[c][r-1] == 0:
            r -= 1

print(answer)