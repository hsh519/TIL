# 백준 9329번 - 패스트 푸드 상금

for i in range(int(input())):
    res = 0
    count = 0
    p_list = []
    p, s = map(int, input().split())

    for i in range(p):
        p_list.append(list(map(int, input().split())))
    
    s_list = list(map(int, input().split()))

    p_list.sort(key= lambda x: x[-1],reverse=True)

    while count != len(p_list):
        for need_s in p_list[count][1:-1]:
            if(s_list[need_s-1] == 0):
                count += 1
                break
            else:
                s_list[need_s-1] -= 1
        else:
            res += p_list[count][-1]
    
    print(res)
            