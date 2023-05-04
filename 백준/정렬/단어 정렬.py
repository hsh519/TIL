# 백준 1181번 - 단어 정렬

l = []

for i in range(int(input())):
    l.append(input())

print()
s =list(set(l))
s.sort()
s.sort(key=lambda x: len(x))

for e in s:
    print(e)