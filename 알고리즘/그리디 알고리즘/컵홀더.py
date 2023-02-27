# 백준 2810번 - 컵홀더

n = int(input())
seat = input()

single = seat.count("S")
couple = seat.count("LL")
cup_holder = single + couple + 1

if cup_holder <= n:
    print(cup_holder)
else:
    print(n)