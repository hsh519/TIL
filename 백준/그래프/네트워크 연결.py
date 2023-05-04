import sys

def find_parent(node,x):
    if node[x] != x:
        node[x] = find_parent(node, node[x])
    return node[x]

def union(node,a,b):
    a = find_parent(node, a)
    b = find_parent(node, b)
    if a < b:
        node[b] = a
    else:
        node[a] = b

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
node = [0] * (n+1)
edges = []
answer = 0

for i in range(m):
    a,b,cost = map(int, sys.stdin.readline().rsplit())
    edges.append((cost,a,b))
    node[a] = a
    node[b] = b

edges.sort()

for edge in edges:
    cost,a,b = edge
    if find_parent(node, a) != find_parent(node, b):
        union(node,a,b)
        answer += cost

print(answer)