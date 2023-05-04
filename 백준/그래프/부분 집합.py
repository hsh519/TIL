# 리트 코드 78번 - 부분 집합
from pip import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]

        def dfs(num, middle_res):
            res.append(middle_res[:])
            if(nums.index(num)+1 != len(nums)):
                for i in nums[nums.index(num)+1:]:
                    middle_res.append(i)
                    dfs(i, middle_res)
            middle_res.pop()

        for num in nums:
            dfs(num, [num])
        
        return res