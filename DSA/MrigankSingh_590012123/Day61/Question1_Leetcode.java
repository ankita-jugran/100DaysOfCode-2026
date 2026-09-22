package Day61;

public class Question1_Leetcode {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            score[a]--;
            score[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
