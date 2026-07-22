from collections import deque

n, k = map(int, input().split())

q = deque(range(1, n + 1))
minute = 0

while q:
    # Serve the person at the front
    minute += 1
    person = q.popleft()

    if person == k:
        print(minute)
        break

    # Move the next front person to the back if their number is odd
    if q and q[0] % 2 == 1:
        q.append(q.popleft())