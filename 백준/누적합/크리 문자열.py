import sys

s = sys.stdin.readline().rstrip()
arr = []
answer = 0

for i in range(len(s)):
    if i == 0:
        arr.append(int(s[i]))
    else:
        arr.append(int(s[i]) + arr[i-1])

for i in range((len(s)//2)*2-1, 1, -2):
    idx = 0
    while idx + i < len(s):
        mid = (i+ 1) // 2 + idx
        left, right = 0, 0
        if idx == 0:
            left = arr[mid-1]
        else:
            left = arr[mid-1] - arr[idx-1]
        right = arr[idx+i] - arr[mid-1]

        if left == right:
            answer = i+1
            break
        idx += 1
    if answer:
        print(answer)
        break