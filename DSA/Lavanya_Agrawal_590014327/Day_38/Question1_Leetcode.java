import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1_Leetcode {

    public static int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();

        for (int student : students) {
            queue.offer(student);
        }

        int sandwichIndex = 0;
        int rotations = 0;

        while (!queue.isEmpty() && sandwichIndex < sandwiches.length) {

            if (queue.peek() == sandwiches[sandwichIndex]) {

                queue.poll();

                sandwichIndex++;

                rotations = 0;

            } else {

                queue.offer(queue.poll());

                rotations++;

                if (rotations == queue.size()) {
                    break;
                }
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String studentLine = sc.nextLine();
        String sandwichLine = sc.nextLine();

        int[] students = parseArray(studentLine);
        int[] sandwiches = parseArray(sandwichLine);

        int result = countStudents(students, sandwiches);

        System.out.println(result);

        sc.close();
    }

    public static int[] parseArray(String line) {

        String numbers = line
                .replaceAll("[^0-9 ]", " ")
                .trim();

        String[] parts = numbers.split("\\s+");

        int[] array = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        return array;
    }
}