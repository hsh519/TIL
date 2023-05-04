n = int(input())
s = input()
h, t = s[0], s[-1]
red, blue, res = [], [], []
m = ""

if s.count('R') == n or s.count('B') == n:
    print(0)
else:
    for i in range(len(s)-1):
        if s[i+1] != s[0]:
            if s[0] == 'R':
                red.append(i+1)
            else:
                blue.append(i+1)
            s = s[i+1:]
            break
    
    for i in range(len(s)-2,-1,-1):
        if s[-1] != s[i]:
            if s[-1] == 'R':
                red.append(len(s)-i-1)
            else:
                blue.append(len(s)-i-1)
            s = s[:i+1]
            break

    if h != t:
        res.append(s.count('R'))
        res.append(s.count('B'))
    else:
        if red == []:
            res.append(s.count('R'))
        else:
            res.append(min(red) + s.count('R'))
        
        if blue == []:
            res.append(s.count('B'))
        else:
            res.append(min(blue) + s.count('B'))
        
    print(min(res))

