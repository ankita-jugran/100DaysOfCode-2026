n = int(input("Enter number of people: "))
h = list(map(int, input("Enter heights: ").split()))

max_visible = 1

for i in range(n):
    visible = 1

    tallest = 0
    for j in range(i - 1, -1, -1):
        if h[j] > tallest:
            visible += 1
            tallest = h[j]

    tallest = 0
    for j in range(i + 1, n):
        if h[j] > tallest:
            visible += 1
            tallest = h[j]

    max_visible = max(max_visible, visible)

print("Maximum people visible:", max_visible)
