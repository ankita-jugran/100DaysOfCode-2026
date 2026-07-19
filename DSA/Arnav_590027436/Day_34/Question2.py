def peopleVisible(arr):
    max_visible = 0
    n = len(arr)
    s = []
    right_counts = [0] * n

    for i in range(n):
        while s and arr[i] >= arr[s[-1]]:        
            right_counts[s[-1]] += 1
            s.pop()
        if s:
            right_counts[s[-1]] += 1
        s.append(i)
    
    s = []
    left_counts = [0] * n
    for i in range(n-1, -1, -1):
        while s and arr[i] >= arr[s[-1]]:        
            left_counts[s[-1]] += 1
            s.pop()
        if s:
            left_counts[s[-1]] += 1
        s.append(i)
    
    for i in range(n):
        Total = 1 + right_counts[i] + left_counts[i]
        max_visible = max(Total, max_visible)
        
    return max_visible