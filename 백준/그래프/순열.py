# 리트코드 46번 - 순열

from pip import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(num, middle_res):
            if(len(nums) == 1):
                res.append([num])
            else:
                for i in nums:
                    if(num == i or i in middle_res):
                        continue
                    middle_res.append(i)
                    if(len(middle_res) == len(nums)):
                        res.append(middle_res[:])
                    else:
                        dfs(i, middle_res)
                    middle_res.pop()
            
        for num in nums:
            dfs(num, [num])
        
        return res
