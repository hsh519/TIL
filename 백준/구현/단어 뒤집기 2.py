import sys

s = sys.stdin.readline().rstrip()
ls = []
word = ''

for c in s:
    if c == '>':
        word += c
        ls.append(word)
        word = ''
    elif c == ' ' and '<' not in word:
        ls.append(word)
        word = c
        ls.append(word)
        word = ''
    elif c == '<' and word:
        ls.append(word)
        word = c
    else:
        word += c
ls.append(word)

for e in ls:
    if '<' in e or e == ' ':
        print(e, end="")
    else:
        print(e[::-1], end="")
