# 백준 1463번 - 1로 만들기

import sys

n = int(sys.stdin.readline())
d = {0:0, 1:0, 2:1, 3:1, 4:2}

if n <= 3:
    print(d[n])
else:
    for i in range(5, n+1):
        d[i] = d[i-1] + 1 # 1을 빼는 경우
        if i % 2 == 0: # 2로 나눠질 경우
            d[i] = min(d[i], d[i//2] + 1) # 1을 뺀 수가 1로 도달하는 횟수와 2로 나눈 수가 1로 도달하는 횟수중 최소값
        if i % 3 == 0: # 3으로 나눠질 경우
            d[i] = min(d[i], d[i//3] + 1) # 1을 뺀 수가 1로 도달하는 횟수와 3로 나눈 수가 1로 도달하는 횟수중 최소값
    print(d[n])
