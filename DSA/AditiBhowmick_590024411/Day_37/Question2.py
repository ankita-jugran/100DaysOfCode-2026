from collections import deque

priorities = list(map(int, input("Enter document priorities: ").split()))
location = int(input("Enter the document location: "))

queue = deque([(priority, index) for index, priority in enumerate(priorities)])

minutes = 0

while queue:
    current = queue.popleft()

    if any(current[0] < doc[0] for doc in queue):
        queue.append(current)
    else:
        minutes += 1
        if current[1] == location:
            print(minutes)
            break