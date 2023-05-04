import sys

n,s = map(int, sys.stdin.readline().rsplit())
arr = [int(e) for e in sys.stdin.readline().rsplit()]
left, right = 0, 0
hap, res = 0, n

for i in range(1,len(arr)):
    arr[i] = arr[i] + arr[i-1]

if arr[-1] < s:
    print(0)
else:
    while left <= right and right < n and left < n:
        if left == 0:
            hap = arr[right]
        else:
            hap = arr[right] - arr[left-1]

        if hap < s:
            right += 1
        else:
            res = min(res, right - left + 1)
            left += 1
    print(res)