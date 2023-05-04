# 리트코드 77번 - 조합

from pip import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        nums = [i+1 for i in range(n)]
        res = []

        def dfs(num, middle_res):
            if(k == 1):
                res.append([num])
            else:
                middle_res.append(num)
                if(len(middle_res) == k):
                    res.append(middle_res[:])
                else:
                    for i in nums[nums.index(num)+1:]:
                        dfs(i, middle_res)
                middle_res.pop()

        for num in nums:
            dfs(num, [])
            
        return res

