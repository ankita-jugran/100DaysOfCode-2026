import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int c = 1, mx = 0;
            for (int j = i - 1; j >= 0; j--)
                if (a[j] > mx) {
                    c++;
                    mx = a[j];
                }
            mx = 0;
            for (int j = i + 1; j < n; j++)
                if (a[j] > mx) {
                    c++;
                    mx = a[j];
                }
            ans = Math.max(ans, c);
        }
        System.out.println(ans);
    }
}