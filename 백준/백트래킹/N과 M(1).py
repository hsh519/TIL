import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().rsplit())
for e in permutations(range(1,n+1), m):
    print(*e)