# 크루스칼 알고리즘 구현

# 특정 원소가 소속된 집합 찾기
def find_parent(node, x):
    # 루트 노드가 아니면
    if node[x] != x:
        # 루트 노드를 찾을 때까지 재귀 호출
        node[x] = find_parent(node, node[x])
    return node[x]

# 합집합 연산
def union(node, a, b):
    a = find_parent(node, a)
    b = find_parent(node, b)
    if a < b:
        node[b] = a
    else:
        node[a] = b

# 노드
node = [0,1,2,3,4,5,6,7] 

# 간선의 대한 정보
edges = [
    (29,1,2), (75,1,5), (35,2,3), 
    (34,2,6), (7,3,4), (23,4,6), 
    (13,4,7), (53,5,6), (25,6,7)
    ]

# 비용의 합
total_cost = 0

# 간선을 비용순으로 오름차순 정렬
edges.sort()

for edge in edges:
    cost, a, b = edge
    # 루트 노드가 동일하지 않으면 사이클이 발생하지 않았다고 판단
    if find_parent(node, a) != find_parent(node, b):
        # 합집합 연산 수행해 최소 신장 트리에 포함
        union(node,a,b)
        print(cost)
        total_cost += cost

print(total_cost)