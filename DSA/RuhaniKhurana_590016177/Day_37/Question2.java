import java.util.*;

class Solution {

    public static List<Integer> cardTrick(int n) {

        Deque<Integer> dq = new ArrayDeque<>();

        for (int card = n; card >= 1; card--) {
            if (!dq.isEmpty()) {
                dq.offerFirst(dq.pollLast());
            }
            dq.offerFirst(card);
        }

        return new ArrayList<>(dq);
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(cardTrick(n));
    }
}