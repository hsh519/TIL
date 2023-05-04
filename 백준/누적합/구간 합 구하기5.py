import sys

n, m = map(int, sys.stdin.readline().rsplit())
arr = []

for i in range(n):
    arr.append([int(e) for e in sys.stdin.readline().rsplit()])

for i in range(len(arr)):
    for j in range(1,n):
        arr[i][j] = arr[i][j] + arr[i][j-1]

prefix_num = [[arr[0][i]] for i in range(len(arr))]

for i in range(len(arr)):
    for j in range(1,n):
        prefix_num[i].append(arr[j][i] + prefix_num[i][j-1])

for i in range(m):
    answer = 0
    x1, y1, x2, y2 = map(int, sys.stdin.readline().rsplit())
    x1, y1, x2, y2 = x1-1, y1-1, x2-1, y2-1
    if x1 == 0 and y1 == 0:
        answer = prefix_num[y2][x2]
    elif x1 == 0:
        answer = prefix_num[y2][x2] - prefix_num[y1-1][x2]
    elif y1 == 0:
        answer = prefix_num[y2][x2] - prefix_num[y2][x1-1]
    else:
        answer = (prefix_num[y2][x2] - prefix_num[y2][x1-1]) - (prefix_num[y1-1][x2] - prefix_num[y1-1][x1-1])

    print(answer)