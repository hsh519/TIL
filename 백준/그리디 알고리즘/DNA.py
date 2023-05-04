# 백준 1969번 - DNA

n ,m = map(int, input().split())
dnas = []
res = ''
res_count = 0


for _ in range(n):
    dnas.append(input())

for i in range(m):
    dna_dick = {'A':0, 'T':0, 'G':0, 'C':0}
    s = ""
    c = 0
    for j in range(n):
        dna_dick[dnas[j][i]] += 1
    
    for k,v in dna_dick.items():
        if v == c and k < s:
            s = k
        elif v > c:
            c = v
            s = k
    res += s
    res_count += n - c

print()
print(res)
print(res_count)

