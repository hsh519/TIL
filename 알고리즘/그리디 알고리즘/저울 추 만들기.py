n = int(input())

if n == 1:
    print(1)
else:
    l = [2**i for i in range(n+1)]
    l1 = [i+1 for i in range(n)]
    l2 = []

    while n-1 > 0:
        for i in range(n-1,-1,-1):
            if (l1[n-1] + l1[i]) in l:
                l2.append(l1[i:n])
                n = i

    for i in range(len(l2)-1,-1,-1):
        l2[i].reverse()
        print(*l2[i], sep=" ", end=" ")