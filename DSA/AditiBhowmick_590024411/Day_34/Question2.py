arr = list(map(int, input("Enter the heights: ").split()))
n = len(arr)
max_visible = 0

for i in range(n):
    visible = 1  # Count the person themself

    # Look to the left
    max_height = 0
    for j in range(i - 1, -1, -1):
        if arr[j] > max_height:
            visible += 1
            max_height = arr[j]

    # Look to the right
    max_height = 0
    for j in range(i + 1, n):
        if arr[j] > max_height:
            visible += 1
            max_height = arr[j]

    max_visible = max(max_visible, visible)
print(max_visible)