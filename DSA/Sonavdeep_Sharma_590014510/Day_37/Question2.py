from collections import deque

n = int(input())
priorities = list(map(int, input().split()))
location = int(input())

queue = deque()

for i in range(n):
    queue.append([i, priorities[i]])

count = 0

while queue:
    current = queue.popleft()

    found = False
    for item in queue:
        if item[1] > current[1]:
            found = True
            break

    if found:
        queue.append(current)
    else:
        count += 1
        if current[0] == location:
            print(count)
            break