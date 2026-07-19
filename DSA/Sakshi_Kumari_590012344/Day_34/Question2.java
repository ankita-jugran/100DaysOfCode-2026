import java.util.Stack;

public class Solution {

    public int maxVisiblePeople(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                right[i]++;
                st.pop();
            }

            if (!st.isEmpty()) {
                right[i]++;
            }

            st.push(i);
        }

        st.clear();

        // People visible on the left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                left[i]++;
                st.pop();
            }

            if (!st.isEmpty()) {
                left[i]++;
            }

            st.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] heights = {10, 6, 8, 5, 11, 9};

        System.out.println(obj.maxVisiblePeople(heights));
    }
}
