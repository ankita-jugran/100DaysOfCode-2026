import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {
    private Deque<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        requests.addLast(t);
        // Remove requests older than the valid window [t - 3000, t]
        while (requests.peekFirst() < t - 3000) {
            requests.pollFirst();
        }
        return requests.size();
    }
}
