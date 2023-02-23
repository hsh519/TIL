# 백준 25773번 - Number Maximization

num_list = []

for num in input():
    num_list.append(num)

num_list.sort(reverse=True)

print(*num_list, sep="")