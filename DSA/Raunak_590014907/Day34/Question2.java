import java.util.Stack;

class Solution {

    public int maxPeopleVisible(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Greater or Equal
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Greater or Equal
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, right[i] - left[i] - 1);
        }

        return max;
    }
}