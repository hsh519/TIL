# 연결 리스트를 이용한 큐 구현

class Node:
    def __init__(self, item):
        self.item = item
        self.next = None

class Queue:
    def __init__(self):
        self.head = None
        self.tail = None

    def push(self, item):
        new_node = Node(item)

        if(not self.head):
            self.head, self.tail = new_node, new_node
        else:
            self.tail.next = new_node
            self.tail = self.tail.next
            
    def pop(self):
        item = self.head.item
        self.head = self.head.next
        
        return item

queue = Queue()

queue.push(1)
queue.push(3)
queue.push(5)
queue.push(7)
queue.push(9)

print(queue.pop())
print(queue.pop())
print(queue.pop())
print(queue.pop())
print(queue.pop())