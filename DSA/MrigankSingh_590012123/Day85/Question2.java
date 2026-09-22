package Day85;

import java.util.Arrays;

public class Question2 {
    public int maxActivities(int[] start, int[] end) {
        int n = start.length;
        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            activities[i][0] = end[i];
            activities[i][1] = start[i];
        }

        Arrays.sort(activities, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int count = 1;
        int lastEnd = activities[0][0];

        for (int i = 1; i < n; i++) {
            if (activities[i][1] >= lastEnd) {
                count++;
                lastEnd = activities[i][0];
            }
        }

        return count;
    }
}
