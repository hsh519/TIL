# 백준 4153번 - 직각삼각형

while True:
    l = list(map(int, input().split()))
    if sum(l) == 0:
        break

    l.sort()
    if l[0]**2 + l[1]**2 == l[2]**2:
        print("right")
    else:
        print("wrong")