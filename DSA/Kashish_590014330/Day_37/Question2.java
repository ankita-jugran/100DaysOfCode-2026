import java.util.*;

public class Question2{

    static class Document {
        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static int printerQueue(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }

        int time = 0;

        while (!queue.isEmpty()) {

            Document current = queue.poll();

            boolean hasHigherPriority = false;

            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                time++;

                if (current.index == location) {
                    return time;
                }
            }
        }

        return -1;
    }

    
}