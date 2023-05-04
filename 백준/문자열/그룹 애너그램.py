# 리트코드 49번 - 그룹 애너그램

from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs):
        # 값을 저장할 딕셔너리와 리스트 선언
        store = defaultdict(list)
        answer = []

        # 문자열 반복
        for string in strs:
            # 문자열의 문자를 정렬
            anagram = ''.join(sorted(string))
            # 정렬한 문자열로 된 키가 있으면 값 추가, 없으면 해당 문자열을 키로 사용해 생성 후 값 추가
            store[anagram].append(string)
        
        # 딕셔너리 값 반복하면서 리스트에 저장
        for v in store.values():
            answer.append(v)
        return answer