import sys

n, m = map(int, sys.stdin.readline().split())
arr = []

for _ in range(n):
    arr.append([int(e) for e in sys.stdin.readline().split()])

for i in range(1,m):
    for j in range(n):
        arr[j][i] = arr[j][i] + arr[j][i-1]

for k in range(int(sys.stdin.readline())):
    i, j, x, y = map(int, sys.stdin.readline().split())
    answer = 0
    for l in range(i-1, x):
        if j == 1:
            answer += arr[l][y-1]
        else:
            answer += arr[l][y-1] - arr[l][j-2]
    print(answer)


