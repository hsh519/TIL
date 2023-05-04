# 백준 9012번 - 괄호
class Node:
    def __init__(self, data, next):
        self.data = data
        self.next = next

class Stack:
    def __init__(self):
        self.top = None
        self.current = None

    def push(self, data):
        if(not self.top):
            self.top = Node(data, self.top)
        else:
            self.current = self.top
            self.top = Node(data, self.top)
            if(self.top.data == ')' and self.current.data == '('):
                self.pop()
                self.pop()
             
    def pop(self):
        self.top = self.top.next

    def is_empty(self):
        if(not self.top):
            print("YES")
        else:
            print("NO")

for _ in range(int(input())):
    stack = Stack()
    s = input()
    for c in s:
        stack.push(c)
    stack.is_empty()
