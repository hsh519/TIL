# 너비 우선 탐색

from collections import deque

def bfs(graph, v, visited):
    # 큐 구현을 위해 deque 라이브러리 사용
    queue = deque([v])
    visited[v] = True

    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        node = queue.popleft()
        print(node, end=" ")
        # 아직 방문하지 않은 인접한 노드들을 큐에 삽입
        for i in graph[node]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)

graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False] * 9
bfs(graph, 1, visited)