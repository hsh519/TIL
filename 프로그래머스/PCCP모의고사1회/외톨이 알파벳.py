def solution(input_string):
    answer = ''
    s = ''
    ls = []
    for e in input_string:
        ls.append(e)
    ls.sort()
    while (ls):
        cnt = ls.count(ls[0])
        s = cnt * ls[0]
        if s not in input_string:
            answer += ls[0]
        del ls[0:cnt]
        
    if answer == '':
        return 'N'
        
    return answer