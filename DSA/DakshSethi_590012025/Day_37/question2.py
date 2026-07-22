from collections import deque

def solution(priorities, location):
    q = deque((p, i) for i, p in enumerate(priorities))
    time = 0

    while q:
        cur = q.popleft()

        if any(cur[0] < x[0] for x in q):
            q.append(cur)
        else:
            time += 1
            if cur[1] == location:
                return time