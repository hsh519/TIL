# 백준 5747번 - Odd or Even

while True:
    count = int(input())

    if not count:
        break

    m = list(map(int, input().split()))
    j = list(map(int, input().split()))
    for i in range(count):
        if m[i] != 0:
            m[i] %= 2
        
        if j[i] != 0:
            j[i] %= 2

    for num in m:
        if (num == 1) and (0 in j):
            count -= 1
            j.remove(0)
        elif (num == 0) and (1 in j):
            count -= 1
            j.remove(1)
    
    print(count)
