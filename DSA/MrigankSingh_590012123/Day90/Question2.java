package Day90;

import java.util.Arrays;

public class Question2 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int clipsUsed = 0;
        int currentEnd = 0;
        int farthestEnd = 0;
        int i = 0;
        int n = clips.length;

        while (currentEnd < time) {
            while (i < n && clips[i][0] <= currentEnd) {
                farthestEnd = Math.max(farthestEnd, clips[i][1]);
                i++;
            }

            if (farthestEnd == currentEnd) {
                return -1;
            }

            clipsUsed++;
            currentEnd = farthestEnd;
        }

        return clipsUsed;
    }
}
