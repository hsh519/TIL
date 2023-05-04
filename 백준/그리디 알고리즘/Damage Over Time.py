# 백준 9785번 - Damage Over Time

n, m = map(int, input().split())
skill_list = []
res_damage = 0
res_time = []

for _ in range(n):
    skill_list.append(list(map(int, input().split())))

skill_list.sort(key= lambda x: (x[0], x[1]), reverse=True)

for i in range(m):
    res_damage += skill_list[i][0]
    res_time.append(skill_list[i][1])

print(res_damage, min(res_time))
