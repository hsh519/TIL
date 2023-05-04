# 리트 코드 39번 - 조합의 합

from pip import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(num, middle_res, target):
            middle_res.append(num)
            rest = target-sum(middle_res)
            if(rest > 0):
                for i in candidates[candidates.index(num):]:    
                    dfs(i, middle_res, target)
            elif(rest == 0):
                res.append(middle_res[:])
            middle_res.pop()
                

        for num in candidates:
            dfs(num, [], target)

        return res