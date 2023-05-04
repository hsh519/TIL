# 백준 24349번 - МЕД

n, a, b, c = input().split()
n, t_to_o, t_to_c, o_to_c = int(n), int(a), int(b), int(c)
now = "t"
walk = 0

while(n-1):
    if now == "t":
        if t_to_o <= t_to_c:
            now = "o"
            walk += t_to_o
        else:
            now = "c"
            walk += t_to_c

    elif now == "o":
        if t_to_o <= o_to_c:
            now = "t"
            walk += t_to_o
        else:
            now = "c"
            walk += o_to_c

    elif now == "c":
        if o_to_c <= t_to_c:
            now = "o"
            walk += o_to_c
        else:
            now = "t"
            walk += t_to_c

    n -= 1

print(walk//100, walk%100)