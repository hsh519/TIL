import sys

n, k = map(int, sys.stdin.readline().rsplit())
arr = [i for i in range(1,n+1)]
idx = k-1
res = [arr[idx]]
arr.remove(arr[idx])
idx -= 1

while arr != []:
    idx += k
    if idx > len(arr)-1:
        idx %= len(arr)
    res.append(arr[idx])
    arr.remove(arr[idx])
    idx -= 1

print("<", end="")
for i in range(len(res)):
    if i == len(res) - 1:
        print(res[i], end="")
    else:
        print(res[i], end=", ")
print(">")