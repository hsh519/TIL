# 리트코드 937번 - 로그 파일 재정렬

class Solution:
    def reorderLogFiles(self, logs):
        num_list = []
        char_list = []

        # 문자로 구성된 로그는 문자 리스트에, 숫자로 구성된 로그는 숫자 리스트에 저장
        for log in logs:
            if log.split()[1].isalpha():
                char_list.append(log)
            else:
                num_list.append(log)
        
        # 식별자를 제외한 문자 비교, 문자가 동일하면 식별자 순으로 정렬
        char_list.sort(key = lambda x: (x.split()[1:], x.split()[0]))

        # 문자 리스트, 숫자 리스트 합치기
        return char_list + num_list