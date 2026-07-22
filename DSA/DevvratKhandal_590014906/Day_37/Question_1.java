import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question_1 {

    Queue<Integer> queue;

    public Question_1() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Question_1 rc = new Question_1();

        System.out.print("Enter number of ping calls: ");
        int n = sc.nextInt();

        System.out.println("Enter ping times:");

        for (int i = 1; i <= n; i++) {
            System.out.print("Ping " + i + ": ");
            int t = sc.nextInt();

            int result = rc.ping(t);

            System.out.println("Number of recent calls = " + result);
        }

        sc.close();
    }
}