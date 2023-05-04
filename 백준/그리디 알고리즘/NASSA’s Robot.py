# 백준 9636번 - NASSA’s Robot

for i in range(int(input())):
    string = input()
    count, x, y = 0, 0, 0

    for s in string:
        if s == 'U':
            y += 1
        elif s == 'R':
            x += 1
        elif s == 'D':
            y -= 1
        elif s == 'L':
            x -= 1
        else:
            count += 1
    
    print(x-count, y-count, x+count, y+count)