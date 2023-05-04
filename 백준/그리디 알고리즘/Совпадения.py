# 백준 18098번 - Совпадения
list = []

n = int(input())

for i in range(n):
    num = int(input())
    if(num <= n) and (num not in list):
        list.append(num)

print(len(list))
