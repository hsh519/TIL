# 백준 15904번 - UCPC는 무엇의 약자일까?

string = input()
check_list = ['U', 'C', 'P', 'C']
idx = 0

for s in string:
    if check_list[idx] == s:
        idx += 1

        if idx == 4:
            break

if idx == 4:
    print('I love UCPC')
else:
    print('I hate UCPC')
