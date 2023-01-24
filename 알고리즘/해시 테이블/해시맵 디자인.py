# 리트코드 706번 - 해시맵 디자인

class MyHashMap:

    def __init__(self):
        self.dict = {}
        

    def put(self, key: int, value: int) -> None:
        self.dict[key] = value
        

    def get(self, key: int) -> int:
        res = self.dict.get(key)
        if(res == 0 or res):
            return res
        return -1
        

    def remove(self, key: int) -> None:
        if(self.dict.get(key) == 0 or self.dict.get(key)):
            del self.dict[key]

myHashMap = MyHashMap()
myHashMap.put(1,1)
myHashMap.put(2,2)
print(myHashMap.get(1))
print(myHashMap.get(3))
myHashMap.put(2,1)
print(myHashMap.get(2))
myHashMap.remove(2)
print(myHashMap.get(2))