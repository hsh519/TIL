# 리트코드 1번 - 두 수의 합

class Solution:
    def twoSum(self, nums, target):

        # 순서대로 반복
        for i in range(len(nums)-1):
            # target에서 현재 값을 뺀 값이 현재 인덱스를 제외한 nums 안에 있으면
            if target - nums[i] in nums[i+1:]:
                # 현재 값 인덱스, target에서 현재 값을 뺀 값 인덱스 리턴
                return [i, nums[i+1:].index(target - nums[i])+i+1]