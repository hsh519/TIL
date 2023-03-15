# 백준 1085번 - 직사각형에서 탈출
x, y, w, h = map(int, input().split())
res = [w-x, x-0, h-y, y-0]
print(min(res))