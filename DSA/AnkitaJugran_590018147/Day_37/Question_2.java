import java.util.LinkedList;
import java.util.Queue;

class PrinterQueue {

    static class Document {
        int priority;
        int index;

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static int printTime(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }

        int time = 0;

        while (!queue.isEmpty()) {

            Document current = queue.poll();

            boolean higherPriorityExists = false;

            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    higherPriorityExists = true;
                    break;
                }
            }

            if (higherPriorityExists) {
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

    public static void main(String[] args) {

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(printTime(priorities, location));
    }
}