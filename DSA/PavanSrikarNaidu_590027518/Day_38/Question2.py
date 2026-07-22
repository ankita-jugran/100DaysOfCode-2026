from collections import deque
from typing import List

def card_trick(n: int) -> List[int]:
    """
    Reconstructs the deck arrangement such that repeatedly:
      1. Revealing the top card
      2. Moving the next card to the bottom
    produces cards in increasing order: 1, 2, 3, ..., n
    """
    positions = deque(range(n))
    result = [0] * n
    
    for value in range(1, n + 1):
        idx = positions.popleft()
        result[idx] = value
        
        if positions:
            positions.append(positions.popleft())
    
    return result


if __name__ == "__main__":
    n = 4
    print(card_trick(n))  