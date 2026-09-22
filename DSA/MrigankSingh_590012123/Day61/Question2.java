package Day61;

public class Question2 {
    private int[] mentorArr;
    private int[] memo;

    public int minGroups(int[] mentor) {
        int n = mentor.length;
        mentorArr = mentor;
        memo = new int[n + 1];

        int best = 0;
        for (int label = 1; label <= n; label++) {
            int d = depthOf(label);
            if (d > best) {
                best = d;
            }
        }
        return best;
    }

    private int depthOf(int label) {
        if (memo[label] != 0) {
            return memo[label];
        }

        int m = mentorArr[label - 1];
        if (m == -1) {
            return memo[label] = 1;
        }

        return memo[label] = 1 + depthOf(m);
    }
}
