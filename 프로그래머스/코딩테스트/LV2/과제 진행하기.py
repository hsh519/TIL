def solution(plans):
    answer = []
    stack = []
    plans.sort(key=lambda x: (int(x[1][0:2]), int(x[1][3:])))
    for i in range(len(plans) -1):
        now_start = int(plans[i][1][0:2]) * 60 + int(plans[i][1][3:])
        next_start = int(plans[i+1][1][0:2]) * 60 + int(plans[i+1][1][3:])
        playtime = int(plans[i][2])
        if next_start - now_start < playtime:
            plans[i][2] = playtime - (next_start - now_start)
            stack.append(plans[i])
        elif next_start - now_start == playtime:
            answer.append(plans[i][0])
        else:
            answer.append(plans[i][0])
            resttime = (next_start - now_start) - playtime
            while stack:
                
                rest = stack.pop()
                if rest[2] == resttime:
                    answer.append(rest[0])
                    break
                elif rest[2] < resttime:
                    answer.append(rest[0])
                    resttime -= rest[2]
                else:
                    rest[2] -= resttime
                    stack.append(rest)
                    break
    answer.append(plans[-1][0])
    while stack:
        answer.append(stack.pop()[0])
    return answer