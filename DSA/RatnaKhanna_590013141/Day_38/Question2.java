import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        Queue<Integer> positions = new LinkedList<>();
        int[] deck = new int[n];

        // Store all positions
        for (int i = 0; i < n; i++) {
            positions.offer(i);
        }

        // Place cards 1 to n
        for (int card = 1; card <= n; card++) {
            int pos = positions.poll();
            deck[pos] = card;

            if (!positions.isEmpty()) {
                positions.offer(positions.poll());
            }
        }

        System.out.println("Initial deck arrangement:");
        System.out.println(Arrays.toString(deck));

        sc.close();
    }
}
