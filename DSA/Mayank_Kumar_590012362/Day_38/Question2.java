import java.util.ArrayDeque;
import java.util.Deque;
public class Question2 {
    public int[] deck(int n) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = n; i >= 1; i--) {
            if (!d.isEmpty()) d.addFirst(d.removeLast());
            d.addFirst(i);
        }
        int[] a = new int[n];
        int i = 0;
        while (!d.isEmpty()) a[i++] = d.removeFirst();
        return a;
    }
}
