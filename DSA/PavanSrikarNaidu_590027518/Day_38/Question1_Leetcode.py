from collections import deque
from typing import List

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        circular = sum(1 for s in students if s == 0)
        square = len(students) - circular
        
        for sandwich in sandwiches:
            if sandwich == 0:
                if circular == 0:
                    return square
                circular -= 1
            else:
                if square == 0:
                    return circular
                square -= 1
        
        return 0


if __name__ == "__main__":
    sol = Solution()
    print(sol.countStudents([1,1,0,0], [0,1,0,1]))       
    print(sol.countStudents([1,1,1,0,0,1], [1,0,0,0,1,1])) 