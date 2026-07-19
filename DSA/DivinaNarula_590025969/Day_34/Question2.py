# Maximum People Visible in a Line

def max_visible_people(arr):
    n = len(arr)

    if n == 0:
        return 0

    max_visible = 1

    for i in range(n):
        visible = 1  
        tallest = 0
        for j in range(i - 1, -1, -1):
            if arr[j] > tallest:
                visible += 1
                tallest = arr[j]

        tallest = 0
        for j in range(i + 1, n):
            if arr[j] > tallest:
                visible += 1
                tallest = arr[j]

        max_visible = max(max_visible, visible)

    return max_visible

n = int(input("Enter the number of people: "))

print("Enter the heights of the people:")
arr = list(map(int, input().split()))

if len(arr) != n:
    print("Error: Please enter exactly", n, "heights.")
else:
    result = max_visible_people(arr)
    print("Maximum people visible:", result)