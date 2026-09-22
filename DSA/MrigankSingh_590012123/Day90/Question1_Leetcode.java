package Day90;

import java.util.Arrays;
import java.util.Comparator;

public class Question1_Leetcode {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        long arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }
}
