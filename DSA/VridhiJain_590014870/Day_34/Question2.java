import java.util.*;
public class Question2  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxVisible = 0;
        for (int i = 0; i < n; i++) {
            int visible = 1;
            int maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > maxHeight) {
                    visible++;
                    maxHeight = arr[j];
                }
                if (arr[j] >= arr[i]) {
                    break;
                }
            }
            maxHeight = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > maxHeight) {
                    visible++;
                    maxHeight = arr[j];
                }
                if (arr[j] >= arr[i]) {
                    break;
                }
            }
            maxVisible = Math.max(maxVisible, visible);
        }
        System.out.println(maxVisible);
    }
}