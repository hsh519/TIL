# 위상 정렬 알고리즘 구현

from collections import deque

# 진출한 간선이 가르키는 노드를 작성한 그래프
graph = [
    [],
    [2,5],
    [3,6],
    [4],
    [7],
    [6],
    [4],
    []
]

# 각 노드별 진입 차수
indegree = [0,0,1,1,1,1,2,1]
res = []
q = deque()

# 진입 차수가 0인 노드를 큐에 삽입
for i in range(1,len(indegree)):
    if indegree[i] == 0:
        q.append(i)

# 큐가 빌때까지 반복
while q:
    # 큐에서 원소 꺼내기
    now = q.popleft()
    res.append(now)
    # 해당 원소와 연결된 노드의 진입 차수 1 뺴기
    for e in graph[now]:
        indegree[e] -= 1
        # 해당 노드의 진입 차수가 0이 되면 큐에 삽입
        if indegree[e] == 0:
            q.append(e)
    
print(res)