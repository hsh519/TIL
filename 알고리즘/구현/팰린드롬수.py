# 백준 1259번 - 팰린드롬수

while True:
    n = input()
    if n == "0":
        break

    if n == n[::-1]:
        print("yes")
    else:
        print("no")
