# 서로소 집합 자료구조 구현

# 특정 원소가 속한 집합 찾기
def find_parent(node, x):
    # 루트 노드가 아니면
    if node[x] != x:
        # 루트 노드를 찾을 때까지 재귀 호출
        node[x] = find_parent(node,node[x])
    return node[x]

# 합집합 연산
def union(node, a, b):
    a = find_parent(node, a)
    b = find_parent(node, b)

    if a < b:
        node[b] = a
    else:
        node[a] = b

node = [0,1,2,3,4,5,6]
# 합집합 연산 수행
union(node, 1, 4)
union(node, 2, 3)
union(node, 2, 4)
union(node, 5, 6)

# 각 노드의 루트 노드 출력
for i in range(1,len(node)):
    print(find_parent(node, i))