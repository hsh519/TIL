# 백준 15829번 - Hashing

l = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

n = int(input())
string = input()
count = 0
res = 0

for s in string:
   res +=  (l.index(s) + 1) * 31**count
   count += 1

if res >= 1234567891:
    print(res%1234567891)
else:
    print(res)