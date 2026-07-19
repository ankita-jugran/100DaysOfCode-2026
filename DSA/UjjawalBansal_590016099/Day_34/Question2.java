import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {
    public static int maximumVisiblePeople(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                stack.clear();
                stack.push(i);
            } 
            else if (arr[i] == max) {
                stack.push(i);
            }
        }

        int ans = 0;
        int rightMax = arr.length;
        int midMax, leftMax;

        while (!stack.isEmpty()) {
            midMax = stack.pop();

            if (!stack.isEmpty())
                leftMax = stack.peek();
            else
                leftMax = -1;

            if (ans < ((rightMax - leftMax) - 1)) {
                ans = ((rightMax - leftMax) - 1);
            }
            rightMax = midMax;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array representing height of the people: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The maximum number of people any single person can see: " + maximumVisiblePeople(arr));
        sc.close();
    }
}