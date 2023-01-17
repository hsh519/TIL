# 백준 10828번 - 스택

import sys

stack = []

for _ in range(int(sys.stdin.readline().rstrip())):
    ment = sys.stdin.readline().rsplit()

    if(ment[0] == "push"):
        stack.append(ment[1])
    elif(ment[0] == "pop"):
        if(not stack):
            print(-1)
        else:
            print(stack.pop())
    elif(ment[0] == "size"):
        print(len(stack))
    elif(ment[0] == "empty"):
        if(not stack):
            print(1)
        else:
            print(0)
    elif(ment[0] == "top"):
        if(not stack):
            print(-1)
        else:
            print(stack[-1])