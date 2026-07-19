import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxVisible = 0;

        for (int i = 0; i < n; i++) {

            int visible = 1; 
            for (int j = i - 1; j >= 0; j--) {

                boolean canSee = true;

                for (int k = j + 1; k < i; k++) {
                    if (arr[k] >= arr[i]) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee && arr[j] < arr[i]) {
                    visible++;
                }
            }
            for (int j = i + 1; j < n; j++) {

                boolean canSee = true;

                for (int k = i + 1; k < j; k++) {
                    if (arr[k] >= arr[i]) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee && arr[j] < arr[i]) {
                    visible++;
                }
            }

            maxVisible = Math.max(maxVisible, visible);
        }

        System.out.println("Maximum people visible = " + maxVisible);

        sc.close();
    }
}