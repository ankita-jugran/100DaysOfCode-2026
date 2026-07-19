def max_visible(arr):
    n = len(arr)
    left = [0] * n
    right = [0] * n
    stack = []

    # Count visible people on the left
    for i in range(n):
        while stack and arr[stack[-1]] < arr[i]:
            stack.pop()
        left[i] = len(stack)
        stack.append(i)

    stack.clear()

    # Count visible people on the right
    for i in range(n - 1, -1, -1):
        while stack and arr[stack[-1]] < arr[i]:
            stack.pop()
        right[i] = len(stack)
        stack.append(i)

    ans = 0
    for i in range(n):
        ans = max(ans, left[i] + right[i] + 1)

    return ans


# Input
arr = list(map(int, input().split()))

# Output
print(max_visible(arr))
