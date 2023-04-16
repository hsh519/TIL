# 리트 코드 42번 - 빗물 트래핑

class Solution:
    def trap(self, height):
        left_top, right_top = height[0], height[-1]
        left, right = 1, len(height) - 2
        answer = 0

        while left <= right:
            left_top = max(left_top, height[left])
            right_top = max(right_top, height[right])
            
            if left_top <= right_top:
                answer += left_top - height[left]
                left += 1
            else:
                answer += right_top - height[right]
                right -= 1
            
        return answer