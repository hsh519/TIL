# 백준 24303번 - ПРЪЧКИ

list = list(map(int, input().split()))
stick = []
res = 0

if(list[0] * list[3] + list[1] * list[4] + list[2] * list[5] < list[6]):
    print(0)
else:
    for i in range(3):
        stick.append([list[i], list[i+3]])

    stick.sort(reverse=True, key= lambda x: x[0])

    for i in range(len(stick)):
        while list[6] > 0:
            if(stick[i][1] == 0):
                break
            list[6] -= stick[i][0]
            stick[i][1] -= 1
            res += 1
    print(res)