from collections import deque

def card_trick(n):
    deck = deque()

    
    for card in range(n, 0, -1):
        if deck:
            
            deck.appendleft(deck.pop())

        
        deck.appendleft(card)

    return list(deck)



n = int(input())


print(card_trick(n))
