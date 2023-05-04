# 백준 10280번 - Pizza voting

n, p = map(int, input().split())
pizza_list = []
a, b = 0, 0

for _ in range(n):
    pizza = list(input().split())
    pizza_list.append(pizza)

favorite_pizza = pizza_list[p-1]

if (n-1)%3 == 1:
    a += (n-1)//3 + 1
    b += (n-1)//3
elif (n-1)%3 == 2:
    a += (n-1)//3 + 1
    b += (n-1)//3 + 1
else:
    a += (n-1)//3
    b += (n-1)//3

for i in range(a):
    pizza_list[-1-i] = [0,0]

for i in range(b):
    pizza_list[i] = [0,0]

if favorite_pizza in pizza_list:
    print('YES')
else:
    print('NO')
