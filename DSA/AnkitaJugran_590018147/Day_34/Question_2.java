import java.util.Stack;

public class VisiblePeopleinLine {

    public static int maxPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        int best = 0;
        for (int i = 0; i < n; i++) {
            int leftCount  = i - left[i] - 1;
            int rightCount = right[i] - i - 1;
            int total = leftCount + rightCount + 1;


            if (total > best) {
                best = total;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Answer for arr1: " + maxPeopleVisible(arr1));

        System.out.println();

        int[] arr2 = {1, 3, 6, 4};
        System.out.println("Answer for arr2: " + maxPeopleVisible(arr2));
    }
}
    
