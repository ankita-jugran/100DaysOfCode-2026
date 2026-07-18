import java.util.Scanner;

public class Main {

    public static int maxVisiblePeople(int[] arr) {
        int n = arr.length;
        int maxVisible = 0;

        for (int i = 0; i < n; i++) {
            int visible = 1; // Count the person themselves

            // Check people on the left
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > maxLeft) {
                    visible++;
                    maxLeft = arr[j];
                }
            }

            // Check people on the right
            int maxRight = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > maxRight) {
                    visible++;
                    maxRight = arr[j];
                }
            }

            maxVisible = Math.max(maxVisible, visible);
        }

        return maxVisible;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        // Input array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Output result
        System.out.println(maxVisiblePeople(arr));

        sc.close();
    }
}
