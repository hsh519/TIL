# 리트코드 771번 - 보석과 돌

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        self.dict = {}
        res = 0

        for alpha in jewels:
            self.dict[alpha] = stones.count(alpha)
        
        for value in self.dict.values():
            res += value

        return res