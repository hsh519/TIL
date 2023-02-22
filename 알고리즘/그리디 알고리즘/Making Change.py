# 백준 27106번 - Making Change

rest = 100 - int(input())
change_list = [25, 10, 5, 1]
count = []

for change in change_list:
    count.append(rest // change)
    rest %= change

print(*count)