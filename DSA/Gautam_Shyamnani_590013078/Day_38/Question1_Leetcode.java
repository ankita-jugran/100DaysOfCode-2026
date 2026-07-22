class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count[] = new int[2];

        for(int s : students){
            count[s]++;
        }
        for(int s : sandwiches){
            if(count[s] == 0){
                return count[0] + count[1];
            }
            count[s]--;
        }
        return 0;
    }
}