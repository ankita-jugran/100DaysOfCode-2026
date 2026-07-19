n = int(input())
arr = list(map(int, input().split()))

max_visible = 1

for i in range(n):
    count = 1

   
    j = i - 1
    while j >= 0:
        count += 1
        if arr[j] >= arr[i]:
            break
        j -= 1

    
    j = i + 1
    while j < n:
        count += 1
        if arr[j] >= arr[i]:
            break
        j += 1

    max_visible = max(max_visible, count)

print(max_visible)