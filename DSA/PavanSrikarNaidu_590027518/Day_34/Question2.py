def maxVisiblePeople(arr):
    n = len(arr)

    left = [0] * n
    right = [0] * n

    # Visible on the left
    stack = []
    for i in range(n):
        while stack and arr[stack[-1]] < arr[i]:
            left[i] += 1
            stack.pop()

        if stack:
            left[i] += 1

        stack.append(i)

    # Visible on the right
    stack = []
    for i in range(n - 1, -1, -1):
        while stack and arr[stack[-1]] < arr[i]:
            right[i] += 1
            stack.pop()

        if stack:
            right[i] += 1

        stack.append(i)

    ans = 0
    for i in range(n):
        ans = max(ans, left[i] + right[i] + 1)

    return ans


arr = [6, 2, 5, 4, 5, 1, 6]
print(maxVisiblePeople(arr))   # 6