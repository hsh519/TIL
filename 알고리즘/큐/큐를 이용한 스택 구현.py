# 큐를 이용한 스택 구현 - 리트코드 225

import collections

class MyStack:

    def __init__(self):
        self.dq = collections.deque()
        
    def push(self, x: int) -> None:
        self.dq.append(x)
        
    def pop(self) -> int:
        return self.dq.pop()

    def top(self) -> int:
        copy_dq = self.dq.copy()
        return copy_dq.pop()

    def empty(self) -> bool:
        if(self.dq):
            return False
        else:
            return True

obj = MyStack()
obj.push(1)
obj.push(2)
print(obj.pop())
print(obj.top())
print(obj.empty())