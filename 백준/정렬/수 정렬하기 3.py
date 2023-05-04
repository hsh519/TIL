# 백준 10989번 - 수 정렬하기 3

import sys

arr = [0 for _ in range(10001)]
for _ in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())
    if arr[n] == 0:
        arr[n] = 1
    else:
        arr[n] += 1

for i in range(10001):
    if arr[i] == 0:
        continue
    for _ in range(arr[i]):
        print(i)