class Solution:
    def maxPeople(self, arr):
        n = len(arr)

        left = [0] * n
        right = [0] * n

        stack = []

        for i in range(n):
            while stack and arr[stack[-1]] < arr[i]:
                stack.pop()
            if stack:
                left[i] = i - stack[-1]
            else:
                left[i] = i
            stack.append(i)

        stack.clear()

        for i in range(n - 1, -1, -1):
            while stack and arr[stack[-1]] < arr[i]:
                stack.pop()
            if stack:
                right[i] = stack[-1] - i
            else:
                right[i] = n - 1 - i
            stack.append(i)

        ans = 1

        for i in range(n):
            ans = max(ans, left[i] + right[i] + 1)

        return ans
