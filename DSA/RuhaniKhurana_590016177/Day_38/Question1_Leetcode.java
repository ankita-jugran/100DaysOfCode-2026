import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();

        for (int student : students) {
            queue.offer(student);
        }

        int index = 0;
        int rotations = 0;

        while (!queue.isEmpty() && rotations < queue.size()) {

            if (queue.peek() == sandwiches[index]) {
                queue.poll();
                index++;
                rotations = 0;
            } else {
                queue.offer(queue.poll());
                rotations++;
            }
        }

        return queue.size();
    }
}