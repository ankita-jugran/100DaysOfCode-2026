import java.util.LinkedList;
import java.util.Queue;
public class Question2 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            int current = queue.remove();
            boolean highest = true;
            for (int i = 0; i < priorities.length; i++) {
                if (queue.contains(i)) {
                    if (priorities[i] > priorities[current]) {
                        highest = false;
                        break;
                    }
                }
            }
            if (highest == true) {
                minutes++;
                if (current == location) {
                    System.out.println(minutes);
                    break;
                }
            } else {
                queue.add(current);
            }
        }
    }
}