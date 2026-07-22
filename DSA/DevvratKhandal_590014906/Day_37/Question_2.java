import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Document {
    int priority;
    int index;

    Document(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

public class Question_2 {

    public static int printerQueue(int[] priorities, int location) {

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

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of documents: ");
        int n = sc.nextInt();

        int[] priorities = new int[n];

        System.out.println("Enter priorities of documents:");

        for (int i = 0; i < n; i++) {
            System.out.print("Priority of document " + (i + 1) + ": ");
            priorities[i] = sc.nextInt();
        }

        System.out.print("Enter location of your document (0 to " + (n - 1) + "): ");
        int location = sc.nextInt();

        int result = printerQueue(priorities, location);

        System.out.println("Number of minutes until your document is printed = " + result);

        sc.close();
    }
}