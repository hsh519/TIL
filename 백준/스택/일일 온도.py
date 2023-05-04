# 일일 온도 - 리트코드 739

def DailyTemperatures(list) -> list:
    stack = []

    res = [0 for _ in list]

    for e in range(len(list)):
        if(not stack):
            stack.append(e)
        else:
            while(stack and list[stack[-1]] < list[e]):
                last = stack.pop()
                res[last] = e - last
            stack.append(e)
    return res
   
print(DailyTemperatures([73,74,75,71,69,72,76,73]))
