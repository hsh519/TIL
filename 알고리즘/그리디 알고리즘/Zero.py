# 백준 26552번 - Zero

for _ in range(int(input())):
    k = int(input())
    while("0" in str(k+1)):
        k += 1
    print(k+1)