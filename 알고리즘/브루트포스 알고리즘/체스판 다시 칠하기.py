# 백준 1018번 - 체스만 다시 칠하기

import sys

chesspan_1 = 'BWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWB'
chesspan_2 = 'WBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBW'

n, m = map(int, sys.stdin.readline().split())
l = [sys.stdin.readline() for _ in range(n)]
res = []

for i in range(m-7):
    for j in range(n-7):
        check = ''
        count_1, count_2 = 0, 0
        for k in range(8):
            check += l[j+k][i:i+8]

        for o in range(len(check)):
            if check[o] != chesspan_1[o]:
                count_1 += 1
            if check[o] != chesspan_2[o]:
                count_2 += 1
        res.append(count_1)
        res.append(count_2)
print(min(res))

                
        