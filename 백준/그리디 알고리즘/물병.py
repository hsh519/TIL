# 백준 1052번 - 물병

n, k = map(int, input().split())
l = []
count = 0
res = 0

while n > 1:
    if n%2!=0:
        l.append(n%2*(2**count))
    n = n // 2
    count += 1

l.append(2**count)

if len(l) + 1 <= k:
    print(0)
else:
    if k==1 and len(l)==1:
        print(2**count - l[0])
    else:
        num = l[-k]

        while l[0] != num:
            if l[0] not in l[1:]:
                res += l[0]
            l[0] *= 2

        print(res)
