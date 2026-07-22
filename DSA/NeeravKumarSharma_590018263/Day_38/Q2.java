import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class Q2 {

    public static void main(String[] args) {
        int n = 4;
        int[] result = reconstructDeck(n);
        System.out.println("Output: " + Arrays.toString(result));
    }

    public static int[] reconstructDeck(int n) {
        Deque<Integer> deck = new LinkedList<>();

        for (int i = n; i >= 1; i--) {
            if (!deck.isEmpty()) {
                int bottomCard = deck.removeLast();
                deck.addFirst(bottomCard);
            }
            
            deck.addFirst(i);
        }
        int[] result = new int[n];
        int index = 0;
        for (int card : deck) {
            result[index++] = card;
        }

        return result;
    }
}