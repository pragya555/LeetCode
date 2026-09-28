class Solution:
    def maxDepth(self, s: str) -> int:
        left = 0
        right = 0
        max1 = 0

        for i in s:
            if i == '(':
                left += 1

            if i == ')':
                right += 1

            max1 = max(max1, left - right)

        return max1