import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {

    public static int[] cardTrick(int n) {

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.offerLast(i);
        }

        int[] result = new int[n];

        for (int card = 1; card <= n; card++) {

            int position = deque.pollFirst();

            result[position] = card;

            if (!deque.isEmpty()) {
                deque.offerLast(deque.pollFirst());
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int n = Integer.parseInt(
                input.replaceAll("[^0-9]", "")
        );

        int[] result = cardTrick(n);

        System.out.print("[");

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);

            if (i < n - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}