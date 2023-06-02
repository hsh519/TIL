import sys

w, h = map(int, sys.stdin.readline().rsplit())
ls = list(map(int, sys.stdin.readline().rsplit()))
answer = 0

for i in range(1, len(ls)-1):
    left = max(ls[:i])
    right = max(ls[i+1:])
    if left != 0 and right != 0 and left > ls[i] and right > ls[i]:
        answer += min(left, right) - ls[i]

print(answer)