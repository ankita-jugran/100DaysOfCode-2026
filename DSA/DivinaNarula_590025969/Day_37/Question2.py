# Printer Queue

from collections import deque

priorities = list(map(int, input("Enter document priorities: ").split()))
location = int(input("Enter target document location: "))

queue = deque()

for i in range(len(priorities)):
    queue.append((priorities[i], i))

minutes = 0

while queue:
    current = queue.popleft()

    if any(current[0] < doc[0] for doc in queue):
        queue.append(current)
    else:
        minutes += 1

        if current[1] == location:
            print("Time taken:", minutes, "minute(s)")
            break