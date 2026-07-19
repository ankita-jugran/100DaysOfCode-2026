import java.util.*;

public class Main {

    public static int maximumPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] leftGreater = new int[n];
        int[] rightGreater = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Nearest Greater or Equal on Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                leftGreater[i] = -1;
            else
                leftGreater[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Nearest Greater or Equal on Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                rightGreater[i] = n;
            else
                rightGreater[i] = stack.peek();

            stack.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int visible = (i - leftGreater[i] - 1)
                        + (rightGreater[i] - i - 1)
                        + 1;

            ans = Math.max(ans, visible);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(maximumPeopleVisible(arr));
    }
}