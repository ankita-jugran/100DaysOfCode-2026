import java.util.*;

public class Main {

    public static int maximumVisiblePeople(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Count visible people on left
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
                left[i]++;
            }

            if (!stack.isEmpty()) {
                left[i]++;
            }

            stack.push(i);
        }

        stack.clear();

        // Count visible people on right
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
                right[i]++;
            }

            if (!stack.isEmpty()) {
                right[i]++;
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

        int[] arr = {6, 2, 5, 4, 5, 1, 6};

        System.out.println(maximumVisiblePeople(arr));
    }
}
