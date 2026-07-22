import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    static class Document {
        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public int printerQueue(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        int[] counts = new int[10];

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
            counts[priorities[i]]++;
        }

        int currentPriority = 9;
        while (currentPriority > 0 && counts[currentPriority] == 0) {
            currentPriority--;
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            Document document = queue.poll();

            if (document.priority < currentPriority) {
                queue.offer(document);
            } else {
                minutes++;
                counts[document.priority]--;

                if (document.index == location) {
                    return minutes;
                }

                while (currentPriority > 0 && counts[currentPriority] == 0) {
                    currentPriority--;
                }
            }
        }

        return minutes;
    }
}