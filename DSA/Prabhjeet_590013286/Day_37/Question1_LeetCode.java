/**
 * LeetCode 933 - Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/
 */

//Need to keep only the calls made in the last 3000 ms

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {

        queue.offer(t);

        // remove calls that are outside the time window
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}