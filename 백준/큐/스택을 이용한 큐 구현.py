# 스택을 이용한 큐 구현 - 리트코드 232

class MyQueue:

    def __init__(self):
        self.stack = []
        
    def push(self, x: int) -> None:
        self.stack.insert(0, x)

    def pop(self) -> int:
        return self.stack.pop()
        
    def peek(self) -> int:
        return self.stack[-1]
        
    def empty(self) -> bool:
        return not self.stack
        
obj = MyQueue()
obj.push(1)
obj.push(2)
print(obj.pop())
print(obj.peek())
print(obj.empty())