import sys, math

s = sys.stdin.readline().rstrip()
answer = 0
num_list = [0,0,0,0,0,0,0,0,0,0]

for c in s:
    num_list[int(c)] += 1

num_list[6] = math.ceil((num_list[6] + num_list[9]) / 2)

print(max(num_list[:9]))