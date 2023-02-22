# 백준 11034번 - 캥거루 세마리2
while(True):
    try:
        locate = list(map(int, input().split()))
        left = locate[1] - locate[0]
        right = locate[2] - locate[1]
        if left >= right :
            print(left - 1)
        else:
            print(right - 1)
    except:
        break
