# 백준 10845번 - 큐

import sys

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.tail = None
        self.head = None

    def push(self, data):
        new_node = Node(data)

        if(not self.head):
            self.head, self.tail = new_node, new_node
        else:
            self.tail.next = new_node
            self.tail = self.tail.next
    
    def pop(self):
        if(not self.head):
            print(-1)
        else:
            item = self.head.data
            self.head = self.head.next
            print(item)

    def size(self):
        if(not self.head):
            print(0)
        else:
            current = self.head
            count = 1
            while(current.next):
                current = current.next
                count += 1
            print(count)

    def empty(self):
        if(not self.head):
            print(1)
        else:
            print(0)
    
    def front(self):
        if(not self.head):
            print(-1)
        else:
            print(self.head.data)

    def back(self):
        if(not self.head):
            print(-1)
        else:
            print(self.tail.data)


queue = Queue()

for _ in range(int(sys.stdin.readline().rstrip())):
    s = sys.stdin.readline().rsplit()
    if(s[0] == 'push'):
        queue.push(s[1])
    elif(s[0] == 'pop'):
        queue.pop()
    elif(s[0] == 'size'):
        queue.size()
    elif(s[0] == 'empty'):
        queue.empty()
    elif(s[0] == 'front'):
        queue.front()
    elif(s[0] == 'back'):
        queue.back()
