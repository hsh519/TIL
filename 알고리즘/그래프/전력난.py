import sys

def find_parent(node, x):
    if node[x] != x:
        node[x] = find_parent(node, node[x])
    return node[x]

def union(node, a, b):
    a = find_parent(node, a)
    b = find_parent(node, b)
    if a < b:
        node[b] = a
    else:
        node[a] = b

while True:
    m, n = map(int, sys.stdin.readline().rsplit())
    if m == 0 and n == 0:
        break
    edges = []
    node = [0] * (m)
    answer = 0
    for _ in range(n):
        a, b, cost = map(int, sys.stdin.readline().rsplit())
        edges.append((cost,a,b))
        node[a] = a
        node[b] = b
        answer += cost
        
    edges.sort()

    for edge in edges:
        cost, a, b = edge
        if find_parent(node, a) != find_parent(node, b):
            union(node, a, b)
            answer -= cost
    print(answer)