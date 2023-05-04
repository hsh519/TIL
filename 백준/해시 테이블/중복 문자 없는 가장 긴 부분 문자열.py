class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        self.dict = {}
        count = 1
        res = 0

        for alpha in s:
            if(not self.dict):
                self.dict[count] = alpha
            else:
                if(self.dict[count].count(alpha)):
                    item = self.dict.get(count)
                    count += 1
                    self.dict[count] = item[item.index(alpha)+1:] + alpha
                else:
                    self.dict[count] = self.dict.get(count) + alpha
        
        for value in self.dict.values():
            tmp = len(value)
            if(res < tmp):
                res = tmp
        
        return res