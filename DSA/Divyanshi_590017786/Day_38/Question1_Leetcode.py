from typing import List

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        count = [0, 0]  # count[0] = circular, count[1] = square

        # Count student preferences
        for student in students:
            count[student] += 1

        # Process sandwiches from top to bottom
        for sandwich in sandwiches:
            if count[sandwich] == 0:
                # No student wants this sandwich
                return count[0] + count[1]

            count[sandwich] -= 1

        return 0