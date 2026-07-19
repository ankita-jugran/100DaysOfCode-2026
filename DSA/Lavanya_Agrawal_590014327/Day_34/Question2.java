import java.util.Scanner;

public class Question2 {

    public static int maxPeopleVisible(int[] arr) {
        int n = arr.length;
        int maxVisible = 1;

        for (int i = 0; i < n; i++) {
            int count = 1; // Count the person themselves

            // Look left
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    count++;
                } else {
                    break;
                }
            }

            // Look right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                } else {
                    break;
                }
            }

            maxVisible = Math.max(maxVisible, count);
        }

        return maxVisible;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxPeopleVisible(arr));

        sc.close();
    }
}