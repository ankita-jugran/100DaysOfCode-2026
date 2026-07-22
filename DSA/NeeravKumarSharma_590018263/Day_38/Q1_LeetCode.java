class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        
        for (int student : students) {
            counts[student]++;
        }
        
        for (int sandwich : sandwiches) {
            if (counts[sandwich] > 0) {
                counts[sandwich]--;
            } 
            else {
                break;
            }
        }
        
        return counts[0] + counts[1];
    }
}