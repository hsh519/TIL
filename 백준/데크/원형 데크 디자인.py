# 원형 데크 디자인 - 리트코드 641

import collections

class MyCircularDeque:

    def __init__(self, k: int):
        self.dq = collections.deque()
        self.k = k

    def insertFront(self, value: int) -> bool:
        if(self.k > 0):
            self.dq.appendleft(value)
            self.k -= 1
            return True
        else:
            return False

    def insertLast(self, value: int) -> bool:
        if(self.k > 0):
            self.dq.append(value)
            self.k -= 1
            return True
        else:
            return False
        
    def deleteFront(self) -> bool:
        if(self.dq):
            self.dq.popleft()
            self.k += 1
            return True
        else:
            return False

    def deleteLast(self) -> bool:
        if(self.dq):
            self.dq.pop()
            self.k += 1
            return True
        else:
            return False

    def getFront(self) -> int:
        if(self.dq):
            res = self.dq.popleft()
            self.dq.appendleft(res)
            return res
        else:
            return -1

    def getRear(self) -> int:
        if(self.dq):
            res = self.dq.pop()
            self.dq.append(res)
            return res
        else:
            return -1

    def isEmpty(self) -> bool:
        return not(bool(self.dq))

    def isFull(self) -> bool:
        return self.k == 0

myCircularDeque = MyCircularDeque(3)
print(myCircularDeque.insertLast(1))
print(myCircularDeque.insertLast(2)) 
print(myCircularDeque.insertFront(3))
print(myCircularDeque.insertFront(4))
print(myCircularDeque.getRear())      
print(myCircularDeque.isFull())
print(myCircularDeque.deleteLast())
print(myCircularDeque.insertFront(4))
print(myCircularDeque.getFront())    