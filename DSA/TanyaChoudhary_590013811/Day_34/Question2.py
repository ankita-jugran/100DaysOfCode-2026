def maxVisiblePeople(heights):
    n = len(heights)
    max_visible = 0
    
    for i in range(n):
        stack = []
        visible = 1        
        
        # look right
        for j in range(i + 1, n):
            while stack and stack[-1] <= heights[j]:
                stack.pop()
            if not stack:
                visible += 1
                stack.append(heights[j])
            else:
                visible += 1
                break
        
        stack = []
        
        # look left
        for j in range(i - 1, -1, -1):
            while stack and stack[-1] <= heights[j]:
                stack.pop()
            if not stack:
                visible += 1
                stack.append(heights[j])
            else:
                visible += 1
                break
        
        max_visible = max(max_visible, visible)
    
    return max_visible

print(maxVisiblePeople([5, 1, 2, 3, 10]))
print(maxVisiblePeople([10, 6, 8, 5, 11, 9]))