import java.util.Stack;

public class Problem2 {
    public int maxPeopleVisible(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n - 1 - i) : (stack.peek() - i - 1);
            stack.push(i);
        }

        int answer = 1;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, left[i] + right[i] + 1);
        }

        return answer;
    }
}