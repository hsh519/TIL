# 백준 1946번 - 신입 사원

import sys

for _ in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())
    m_min, res, l = 0, [], []
    for _ in range(n):
        s, m = map(int, sys.stdin.readline().split())
        l.append([s,m])

    l.sort(key=lambda x: x[0])

    for i in l:
        if not res:
            m_min = i[1]
            res.append(i)
        else:
            if i[1] < m_min:
                m_min = i[1]
                res.append(i)
    print(len(res))