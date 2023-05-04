# 백준 9784번 - Boiled Eggs

for i in range(int(input())):
    n, p, q = map(int, input().split())
    weight_list = list(map(int, input().split()))
    weight = 0
    count = 0

    while len(weight_list):
        weight += min(weight_list)
        if weight > q:
            break

        weight_list.remove(min(weight_list))
        count += 1

        if count == p:
            break

    print("Case {}: {}".format(i+1, count))
