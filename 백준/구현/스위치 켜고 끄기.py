import sys

n = int(sys.stdin.readline())
switch = [0]
ls = list(map(int, sys.stdin.readline().rsplit()))
for e in ls:
    switch.append(e)
p = int(sys.stdin.readline())

for i in range(p):
    s, num = map(int, sys.stdin.readline().rsplit())
    if s == 1:
        for i in range(num, len(switch), num):
            if switch[i] == 1:
                switch[i] = 0
            else:
                switch[i] = 1
    else:
        left = 1
        right = -1
        if switch[num] == 1:
            switch[num] = 0
        else:
            switch[num] = 1

        while num+left < len(switch) and num+right > 0:
            if switch[num+left] == switch[num+right]:
                if switch[num+left] == 1:
                    switch[num+left], switch[num+right] = 0, 0
                else:
                    switch[num+left], switch[num+right] = 1, 1
                left += 1
                right -= 1
            else:
                break

for i in range(1,len(switch)):
    print(switch[i], end=' ')
    if i % 20 == 0:
        print()