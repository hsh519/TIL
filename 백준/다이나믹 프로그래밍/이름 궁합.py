import sys

a = sys.stdin.readline().rstrip()
b = sys.stdin.readline().rstrip()
d = {
    'A': 3,
    'B': 2,
    'C': 1,
    'D': 2,
    'E': 3,
    'F': 3,
    'G': 2,
    'H': 3,
    'I': 3,
    'J': 2,
    'K': 2,
    'L': 1,
    'M': 2,
    'N': 2,
    'O': 1,
    'P': 2,
    'Q': 2,
    'R': 2,
    'S': 1,
    'T': 2,
    'U': 1,
    'V': 1,
    'W': 1,
    'X': 2,
    'Y': 2,
    'Z': 1
}
ls_a = []
ls_b = []
idx = 1
cnt = 0

for c in a:
    ls_a.append(d[c])

for c in b:
    ls_b.append(d[c])

for num in ls_b:
    ls_a.insert(idx, num)
    idx += 2

while True:
    if len(ls_a)-1-cnt == 1:
        break
    for i in range(len(ls_a)-1-cnt):
        ls_a[i] = (ls_a[i] + ls_a[i+1]) % 10
    cnt += 1

print(str(ls_a[0]) + str(ls_a[1]))