# 백준 1041번 - 주사위

import sys

n = int(sys.stdin.readline())
dice_nums = list(map(int, sys.stdin.readline().split()))
if n == 1:
    dice_nums.sort()
    print(sum(dice_nums[:-1]))
else:
    use_nums = [min(dice_nums[5], dice_nums[0]), min(dice_nums[4], dice_nums[1]), min(dice_nums[3], dice_nums[2])]
    use_nums.sort()

    front = use_nums[0] * n**2
    right = use_nums[1] * n * 2 + use_nums[0] * n * (n-2)
    top = use_nums[2] * 4 + use_nums[1] * (n-2) * 4 + use_nums[0] * (n-2)**2

    print(front*2 + right*2 + top)