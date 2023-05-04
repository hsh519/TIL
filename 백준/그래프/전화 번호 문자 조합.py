# 리트 코드 17번 - 전화 번호 문자 조합

from pip import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        def dfs(letter, count, middle_res):
            if(len(digits) == 1):
                middle_res.append(letter)
            else:
                for alpha in letters[int(digits[count])]:
                    input_alpha = letter + alpha
                
                    if(len(digits) - 1 == count):
                        middle_res.append(input_alpha)
                    else:
                        dfs(input_alpha, count+1, middle_res)
            return middle_res
            
        letters = [
            [],
            [],
            ['a', 'b', 'c'],
            ['d', 'e', 'f'],
            ['g', 'h', 'i'],
            ['j', 'k', 'l'],
            ['m', 'n', 'o'],
            ['p', 'q', 'r', 's'],
            ['t', 'u', 'v'],
            ['w', 'x', 'y', 'z']
        ]
        res = []

        if(digits == ""):
            return res
        else:
            for letter in letters[int(digits[0])]:
                middle_res = dfs(letter, 1, [])
                res.extend(middle_res)
        return res