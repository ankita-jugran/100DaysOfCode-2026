def max_visible(arr):
    n = len(arr)
    left = [-1] * n
    right = [n] * n

    stack = []
    for i in range(n):
        while stack and arr[stack[-1]] < arr[i]:
            stack.pop()
        left[i] = stack[-1] if stack else -1
        stack.append(i)

    stack = []
    for i in range(n - 1, -1, -1):
        while stack and arr[stack[-1]] < arr[i]:
            stack.pop()
        right[i] = stack[-1] if stack else n
        stack.append(i)

    return max((i - left[i] - 1) + (right[i] - i - 1) + 1 for i in range(n))

arr = []
n = int(input("Enter the number of elements in the array: "))
for i in range(n):
    element = int(input(f"Enter element {i + 1}: "))
    arr.append(element)

print("Maximum number of visible elements:", max_visible(arr))