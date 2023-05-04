# 백준 4796번 - 캠핑
count = 1

while True:
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v == 0:
        break
    res = (v//p) * l

    if v%p <= l:
        res += v%p
    else:
        res += l
    
    print("Case {}: {}".format(count, res))
    count += 1
