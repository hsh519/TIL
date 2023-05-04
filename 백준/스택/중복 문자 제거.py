# 중복 문자 제거 - 리트코드 316

def removeDuplicateLetters(s: str) -> str:
    stack = []
    res = ""

    for index in range(len(s)):
        alpha = []

        if(not stack):
            stack.append(index)
        else:
            for i in stack:
                alpha.append(s[i])

            if(alpha.count(s[index])):
                continue

            while(s[stack[-1]] >= s[index] and s[index:].count(s[stack[-1]]) >= 1):
                stack.pop()
                if(not stack):
                    break
            stack.append(index)

    for i in stack:
        res += str(s[i])

    return res

print(removeDuplicateLetters("cbacdcbc"))