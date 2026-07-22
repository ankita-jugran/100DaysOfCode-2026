import java.util.*;

public class Main {

    public static List<Integer> cardTrick(int n) {

        Deque<Integer> deck = new LinkedList<>();

        for (int card = n; card >= 1; card--) {

            if (!deck.isEmpty()) {
                deck.addFirst(deck.removeLast());
            }

            deck.addFirst(card);
        }

        return new ArrayList<>(deck);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(cardTrick(n));
    }
}
