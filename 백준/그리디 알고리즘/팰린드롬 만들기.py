# 백준 1213번 - 팰린드롬 만들기

string = input()
l = [s for s in string]
set = set(l)
alpha = ''

if len(string)%2!=0:
    for i in set:
        if l.count(i) %2 != 0:
            alpha = i
            l.remove(i)
            break

l.sort()
res = [0 for _ in range(len(l))]

for i in range(len(l)):
    if i%2==0:
        res[i//2] = l[i]
    else:
        res[len(l)-(i//2)-1] = l[i]

for i in range(len(string)//2):
    if res[i] != res[len(l)-1-i]:
        print("I'm Sorry Hansoo")
        break
else:
    if alpha:
        res.insert(len(string)//2, alpha)
    print(*res, sep="")
