# 원형 큐 디자인 - 리트코드 622
class MyCircularQueue:

    def __init__(self, k: int):
        self.q = []
        self.k = k

    def enQueue(self, value: int) -> bool:
        if(self.k  == 0):
            return False
        else:
            self.q.insert(0, value)
            self.k -= 1
            return True

    def deQueue(self) -> bool:
        if(not self.q):
            return False
        else:
            self.q.pop()
            self.k += 1
            return True
        
    def Front(self) -> int:
        if(not self.q):
            return -1
        return self.q[-1]

    def Rear(self) -> int:
        if(not self.q):
            return -1
        return self.q[0]

    def isEmpty(self) -> bool:
        return not self.q

    def isFull(self) -> bool:
        return self.k == 0
        
myCircularQueue = MyCircularQueue(3)
print(myCircularQueue.enQueue(1))
print(myCircularQueue.enQueue(2))
print(myCircularQueue.enQueue(3))
print(myCircularQueue.enQueue(4))
print(myCircularQueue.Rear())
print(myCircularQueue.isFull())
print(myCircularQueue.deQueue())
print(myCircularQueue.enQueue(4))
print(myCircularQueue.Rear())