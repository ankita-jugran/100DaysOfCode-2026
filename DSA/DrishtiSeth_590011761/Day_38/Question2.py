from collections import deque

def cardTrick(n):
    deck = deque()

    for card in range(n, 0, -1):
        if deck:
            deck.appendleft(deck.pop())
        deck.appendleft(card)

    return list(deck)
