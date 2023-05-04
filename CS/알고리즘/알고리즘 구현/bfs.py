# 너비 우선 탐색
graph = {
    1: [2,3,4],
    2: [5],
    3: [5],
    4: [],
    5: [6,7],
    6: [],
    7: [3]
}

# 큐를 이용한 반복 구조로 구현
def iterative_bfs(start_v):
    discovered = []
    queue = [start_v]

    while queue:
        v = queue.pop(0)
        if v not in discovered:
            discovered.append(v)
            for i in graph[v]:
                queue.append(i)

    return discovered

res = iterative_bfs(1)
print(res)