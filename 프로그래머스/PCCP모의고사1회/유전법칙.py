def solution(queries):
    answer = []
    ls = ['RR', 'Rr', 'Rr', 'rr']
    for i in range(len(queries)):
        if queries[i][0] == 1 and queries[i][1] == 1:
            answer.append('Rr')
            continue
        elif queries[i][0] == 2:
            answer.append(ls[queries[i][1]-1])
            continue
            
        n = 1
        for j in range(queries[i][0]-1):
            n *= 4
        standard = n//4
        while True:
            if queries[i][1] <= standard:
                answer.append('RR')
                break
            elif queries[i][1] >= standard*3 + 1:
                answer.append('rr')
                break
            else:
                queries[i][1] %= standard
                standard = standard // 4
                if standard == 1:
                    answer.append(ls[queries[i][1] - 1])
                    break
    return answer