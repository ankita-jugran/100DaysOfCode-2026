from collections import deque
def printer_queue(priorities, location):
    queue = deque((priority, idx) for idx, priority in enumerate(priorities))
    time = 0
    while queue:
        priority, idx = queue.popleft()

        if any(priority < p for p, _ in queue):
            queue.append((priority, idx))
        else:
            time += 1
            if idx == location:
                return time
priorities = list(map(int, input("Enter priorities (space-separated): ").split()))
location = int(input("Enter document location: "))
result = printer_queue(priorities, location)
print("Minutes until the document is printed:", result)