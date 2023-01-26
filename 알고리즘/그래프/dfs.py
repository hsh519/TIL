# 깊이 우선 탐색
graph = {
    1: [2,3,4],
    2: [5],
    3: [5],
    4: [],
    5: [6,7],
    6: [],
    7: [3]
}

# 재귀 구조로 구현
def recursive_dfs(v, discovered = []):
    discovered.append(v)

    for i in graph[v]:
        if i not in discovered:
            recursive_dfs(i, discovered)
    return discovered

recursive_res = recursive_dfs(1)
print(recursive_res)

# 스택을 이용한 반복 구조로 구현
def iterative_dfs(start_v):
    discovered = []
    stack = [start_v]

    while stack:
        v = stack.pop()
        if v not in discovered:
            discovered.append(v)
            for i in graph[v]:
                stack.append(i)

    return discovered

iterative_res = iterative_dfs(1)
print(iterative_res)