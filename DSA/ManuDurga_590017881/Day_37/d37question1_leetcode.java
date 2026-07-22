package Day_37;

import java.util.*;

public class d37question1_leetcode {
    
    static class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (queue.peek() < t - 3000) {
            queue.remove();
        }

        return queue.size();
    }
}
    
    public static void main(String[] args) {

    }
}
