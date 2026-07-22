from collections import deque
n = int(input())
deck = deque()
for card in range(n, 0, -1):
    if deck:
        deck.appendleft(deck.pop())  
    deck.appendleft(card)
print(list(deck))