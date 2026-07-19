package DSA.Mugdha_590015431.Day_34;
import java.util.*;

public class Question2 {

    public static int maxVisiblePeople(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Left visibility
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                left[i]++;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                left[i]++;
            }

            stack.push(i);
        }

        stack.clear();

        // Right visibility
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                right[i]++;
                stack.pop();
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

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxVisiblePeople(arr));

        sc.close();
    }
}