class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        tmp = 'z'
        res = ""

        for alpha in s:
            if(tmp > alpha):
                tmp = alpha
        
        new_s = s[s.find(tmp):]

        for alpha in new_s:
            if(new_s.count(alpha) >= 2):
                
            else:
                res += alpha

        return res

solution = Solution()
print(solution.removeDuplicateLetters("cbacdcbc"))