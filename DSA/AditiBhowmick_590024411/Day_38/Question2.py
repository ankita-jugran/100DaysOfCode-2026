from collections import deque

n = int(input("Enter the value of n: "))

positions = deque(range(n))
deck = [0] * n

for card in range(1, n + 1):
    pos = positions.popleft()
    deck[pos] = card

    if positions:
        positions.append(positions.popleft())

print("Initial deck arrangement:", deck)