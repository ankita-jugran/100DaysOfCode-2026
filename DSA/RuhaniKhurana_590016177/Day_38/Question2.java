import java.util.*;

class Solution {

    public static List<Integer> cardTrick(int n) {

        Deque<Integer> deque = new ArrayDeque<>();

        for (int card = n; card >= 1; card--) {

            if (!deque.isEmpty()) {
                deque.offerFirst(deque.pollLast());
            }

            deque.offerFirst(card);
        }

        return new ArrayList<>(deque);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(cardTrick(n));
    }
}