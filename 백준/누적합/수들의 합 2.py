import sys

n, m = map(int, sys.stdin.readline().rsplit())
ls = list(map(int, sys.stdin.readline().rsplit()))
answer = 0
left, right = 0, 0
l = len(ls)

for i in range(1,len(ls)):
    ls[i] = ls[i-1] + ls[i]

while left <= l:
    if left == 0:
        if ls[right] > m:
            left += 1
        elif ls[right] == m:
            answer += 1
            if right == l - 1:
                break
            else:
                right += 1
        else:
            if right == l - 1:
                break
            right += 1
    else:
        if ls[right] - ls[left-1] == m:
            answer += 1
            if right < l - 1:
                right += 1
            else:
                left += 1
        elif ls[right] - ls[left-1] < m:
            if right < l - 1:
                right += 1
            else:
                left += 1
        else:
            left += 1

print(answer)