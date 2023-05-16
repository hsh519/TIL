import sys

n = int(sys.stdin.readline())
for i in range(n):
    a, b = map(int, sys.stdin.readline().rsplit())
    top, bottom = 1, 1
    
    for i in range(a):
        top = top * (b-i)
        bottom = bottom * (i+1)

    print(top // bottom)