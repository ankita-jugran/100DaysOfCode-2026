class Solution {
    public int countStudents(int[] a, int[] b) {
        int[] c = new int[2];
        for (int x : a) c[x]++;
        for (int x : b) {
            if (c[x] == 0) return c[0] + c[1];
            c[x]--;
        } return 0;
    }
}