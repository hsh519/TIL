def solution(citations):
    answer = 0
    n = 0
    if max(citations) == 0:
        return 0
    while n <= 10000:
        cnt = 0
        for e in citations:
            if e >= n:
                cnt += 1
        if cnt >= n:
            answer = n
        n += 1
    return answer