# 백준 24387번 - ИЗЛОЖЕНИЕ НА ПЧЕЛЕН МЕД

price_list = list(map(int, input().split()))
price_list.sort(reverse=True)

kg_list = list(map(int, input().split()))
kg_list.sort(reverse=True)
res = 0

for i in range(len(kg_list)):
    res += price_list[i] * kg_list[i]

print(res)