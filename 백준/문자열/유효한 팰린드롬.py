# 리트코드 125번 - 유효한 팰린드롬

from collections import deque
class Solution:
    def isPalindrome(self, s: str) -> bool:
        dq: deque = deque()

        # 영숫자 문자만 추출
        for char in s:
            # 영문자면 소문자로 저장
            if char.isalnum():
                dq.append(char.lower())

        # 영숫자 문자가 없다면 빈 문자이므로 true 리턴
        if len(dq) == 0:
            return True
        
        # 홀수, 짝수 관계없이 추출한 문자 개수의 반만 반복
        for _ in range(len(dq) // 2):
            # 양 끝 문자가 다르면 false 리턴
           if dq.pop() != dq.popleft():
               return False

        # 모든 반복을 마치면 팰린드롬이므로 true 리턴
        return True