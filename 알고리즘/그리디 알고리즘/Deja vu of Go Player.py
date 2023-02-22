# 백준 23663번 - Deja vu of Go Player

for i in range(int(input())):
    n, m = input().split()
    n, m = int(n), int(m)

    n_list = list(map(int, input().split()))
    m_list = list(map(int, input().split()))

    if n > m:
        print("No")
    else:
        print("Yes")