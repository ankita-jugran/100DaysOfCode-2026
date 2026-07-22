import java.util.*;

public class Main {
    public static List<Integer> cardTrick(int n) {
        LinkedList<Integer> deck = new LinkedList<>();

        for (int card = n; card >= 1; card--) {
            if (!deck.isEmpty()) {
                deck.addFirst(deck.removeLast());
            }
            deck.addFirst(card);
        }

        return deck;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(cardTrick(n));
    }
}
