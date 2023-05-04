# 백준 1436번 - 영화감독 숌

import sys

n = int(sys.stdin.readline())
count = 666

while True:
    if "666" in str(count):
        n -= 1
        if n == 0:
            break
    
    count += 1

print(count)