# 백준 2751번 - 수 정렬하기 2
import sys

l = []

for _ in range(int(sys.stdin.readline())):
    l.append(int(sys.stdin.readline()))

l.sort()

print(*l, sep="\n")