class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2]; // count[0] = students who want circular, count[1] = students who want square
        for (int s : students) {
            count[s]++;
        }

        int i = 0; // pointer into sandwiches stack
        while (i < sandwiches.length && count[sandwiches[i]] > 0) {
            count[sandwiches[i]]--;
            i++;
        }

        // Remaining students = those who couldn't be matched
        return count[0] + count[1];
    }
}
