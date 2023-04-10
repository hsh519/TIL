# 리트코드 819번 - 가장 흔한 단어

from collections import Counter
import re
class Solution:
    def mostCommonWord(self, paragraph: str, banned) -> str:
        # 소문자, 대문자를 제외한 문자는 공백으로 치환
        paragraph = re.sub('[^a-zA-Z]', ' ', paragraph)
        # 금지된 단어를 제외하고 워드 리스트에 저장
        word_list = [word.lower() for word in paragraph.split() if word.lower() not in banned]
        # 워드 리스트에서 가장 많이 나온 단어를 리턴
        return Counter(word_list).most_common(1)[0][0]

