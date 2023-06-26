import sys
from collections import deque

def dfs(start, s):
    q = deque()
    q.append([s, start])

    while q:
        now_s, now_i = q.popleft()
        
        if now_i == len(node) or len(node) - now_i < l - len(now_s):
            continue
        for c in node[now_i]:
            new_s = now_s + c
            if len(new_s) >= l:
                f_s = list(filter(lambda x: x not in ['a', 'e', 'i', 'o', 'u'], new_s))
                if len(f_s) >= 2 and len(new_s) - len(f_s) >= 1:
                    print(new_s)
            else:
                q.append([new_s, ls.index(c)])


l, c = map(int, sys.stdin.readline().rsplit())
ls = list(sys.stdin.readline().rstrip().rsplit())
ls.sort()
node = []

for i in range(len(ls)-1):
    res = []
    for j in range(i+1, len(ls)):
        res.append(ls[j])
    node.append(res)

for i in range(len(ls)-l+1):
    dfs(i, ls[i])
