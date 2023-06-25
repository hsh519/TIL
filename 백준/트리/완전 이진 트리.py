import sys

k = int(sys.stdin.readline())
middle = (2**k - 1) // 2
tree = list(map(int, sys.stdin.readline().rsplit()))

while tree.count(0) != 2**(k-1)-1:
    res = []

    for i in range(middle, len(tree), middle+1):
        if tree[i] != 0:
            res.append(tree[i])
            tree[i] = 0
    
    middle = middle // 2
    
    print(*res)

for e in tree:
    if e != 0:
        print(e, end=" ")