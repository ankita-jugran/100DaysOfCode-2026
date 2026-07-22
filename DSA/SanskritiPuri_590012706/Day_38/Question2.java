import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static int[] cardTrick(int n) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = n; i >= 1; i--) {
            if (!deque.isEmpty()) {
                // Reverse of moving top card to bottom:
                // move last card to the front
                deque.addFirst(deque.removeLast());
            }
            // Place current card at the top
            deque.addFirst(i);
        }

        int[] result = new int[n];
        int index = 0;

        while (!deque.isEmpty()) {
            result[index++] = deque.removeFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ans1 = cardTrick(4);
        for (int x : ans1) System.out.print(x + " ");
        System.out.println();

        int[] ans2 = cardTrick(3);
        for (int x : ans2) System.out.print(x + " ");
        System.out.println();

        int[] ans3 = cardTrick(5);
        for (int x : ans3) System.out.print(x + " ");
    }
}
