import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int printerQueue(int[] priorities, int location) {
        Deque<int[]> queue = new ArrayDeque<>(); // each element: {priority, originalIndex}
        for (int i = 0; i < priorities.length; i++) {
            queue.addLast(new int[]{priorities[i], i});
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            int[] front = queue.pollFirst();

            // Check if any remaining document has a higher priority
            boolean hasHigherPriority = false;
            for (int[] doc : queue) {
                if (doc[0] > front[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.addLast(front); // requeue to the back
            } else {
                minutes++; // print it
                if (front[1] == location) {
                    return minutes;
                }
            }
        }

        return minutes; // fallback, shouldn't be reached if location is valid
    }
}
