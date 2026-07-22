import java.util.*;

class Document {
    int priority;
    int index;

    Document(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

public class Main {

    public static int printTime(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<>();

        // Add all documents to the queue
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }

        int time = 0;

        while (!queue.isEmpty()) {

            Document current = queue.poll();

            boolean hasHigher = false;

            // Check if any document has higher priority
            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current);
            } else {
                time++;

                if (current.index == location) {
                    return time;
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] priorities = new int[n];

        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        int location = sc.nextInt();

        System.out.println(printTime(priorities, location));

        sc.close();
    }
}