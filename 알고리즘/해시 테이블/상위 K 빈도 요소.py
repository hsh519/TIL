from pip import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        self.dict = {}
        s = set(nums)
        res = []

        for num in s:
            self.dict[num] = nums.count(num)
        
        res = sorted(self.dict.keys(), key=lambda item: self.dict.get(item), reverse=True)

        return res[:k]