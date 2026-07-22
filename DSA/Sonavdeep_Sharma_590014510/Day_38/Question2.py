from collections import deque

n = int(input())

deck = deque()

for i in range(n, 0, -1):
    if deck:
        deck.appendleft(deck.pop())  
    deck.appendleft(i)               

print(*deck)