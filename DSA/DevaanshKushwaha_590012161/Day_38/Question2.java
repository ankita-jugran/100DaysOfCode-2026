import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] deckRevealedIncreasing(int n) {
        Deque<Integer> positions = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            positions.addLast(i);
        }

        int[] result = new int[n];

        for (int value = 1; value <= n; value++) {
            int index = positions.pollFirst();
            result[index] = value;

            if (!positions.isEmpty()) {
                positions.addLast(positions.pollFirst());
            }
        }

        return result;
    }
}
