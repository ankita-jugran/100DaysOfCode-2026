import java.util.*;

class Solution {
    public int maxPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Count visible people on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = i;
            } else {
                left[i] = i - stack.peek() - 1;
            }

            stack.push(i);
        }

        stack.clear();

        // Count visible people on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n - i - 1;
            } else {
                right[i] = stack.peek() - i - 1;
            }

            stack.push(i);
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {6, 2, 5, 4, 5, 1, 6};

        System.out.println(obj.maxPeopleVisible(arr));
    }
}
