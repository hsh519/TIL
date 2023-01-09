# 연결 리스트를 이용한 스택
class Node:
    def __init__(self, item, next):
        self.item = item
        self.next = next

class Stack:
    def __init__(self):
        self.top = None

    def push(self, item):
        self.top = Node(item, self.top)

    def pop(self):
        item = self.top.item
        self.top = self.top.next
        return item


stack = Stack()

stack.push(1)
stack.push(3)
stack.push(5)
stack.push(7)
stack.push(9)

print(stack.pop())
print(stack.pop())
print(stack.pop())
print(stack.pop())
print(stack.pop())