# 백준 8321번 - Tables

n, k ,s = map(int, input().split())
n_list = list(map(int, input().split()))
need_n = k*s
res = 0

while need_n > 0:
    use_n = max(n_list)
    need_n -= use_n
    n_list.remove(use_n)
    res += 1

print(res)