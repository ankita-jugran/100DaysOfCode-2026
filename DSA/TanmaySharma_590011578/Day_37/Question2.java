package DSA.TanmaySharma_590011578.Day_37;

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

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of documents: ");
        int n = sc.nextInt();

        int[] priorities = new int[n];

        System.out.println("Enter document priorities:");
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        System.out.print("Enter target document location: ");
        int location = sc.nextInt();

        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new Document(priorities[i], i));
        }

        int minutes = 0;

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
                minutes++;
                if (current.index == location) {
                    System.out.println("Time taken to print the target document: " + minutes + " minute(s)");
                    break;
                }
            }
        }

        sc.close();
    }
}
