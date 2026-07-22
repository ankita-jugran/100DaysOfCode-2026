import java.util.*;

class Solution {
    public int[] cardTrick(int n) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = n; i >= 1; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(i);
        }

        int[] result = new int[n];
        int index = 0;

        while (!deque.isEmpty()) {
            result[index++] = deque.removeFirst();
        }

        return result;
    }
}