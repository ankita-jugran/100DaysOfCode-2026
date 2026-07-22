import java.util.*;

public class Question2 {

    public static int[] findInitialDeck(int n) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = n; i >= 1; i--) {
            if (!dq.isEmpty()) {
                dq.addFirst(dq.removeLast()); // reverse operation
            }
            dq.addFirst(i);
        }

        int[] result = new int[n];
        int index = 0;
        for (int x : dq) {
            result[index++] = x;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] result = findInitialDeck(n);

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}