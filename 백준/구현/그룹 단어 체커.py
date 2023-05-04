import sys
from collections import defaultdict

n = int(sys.stdin.readline())
answer = 0

for _ in range(n):
    s = sys.stdin.readline().rstrip()
    d = defaultdict(int)
    str_sum = ""

    for c in s:
        d[c] += 1

    for k, v in d.items():
        str_sum += k * v
    
    if str_sum == s:
        answer += 1
print(answer)
        