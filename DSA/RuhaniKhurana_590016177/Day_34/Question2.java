import java.util.*;

class Solution {
    public int maxPeopleVisible(int[] heights) {
        int n = heights.length;
        int[] v = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                v[i]++;
                stack.pop();
            }
            if (!stack.isEmpty()) {
                v[i]++;
            }
            if (!stack.isEmpty()) {
                v[i]++;
            }

            stack.push(heights[i]);
        }

        int maxVisible = 0;

        for (int count : v) {
            maxVisible = Math.max(maxVisible, count + 1);
        }

        return maxVisible;
    }
}