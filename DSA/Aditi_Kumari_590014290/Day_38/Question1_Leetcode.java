package Day_38;
import java.util.*;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue=new ArrayDeque<>();
        for (int student:students){
            queue.offer(student);
        }
        int sIndex=0;
        int rotation=0;
        while (!queue.isEmpty()){
            if (queue.peek() == sandwiches[sIndex]){
                queue.poll();
                sIndex++;
                rotation=0;
            }
            else{
                queue.offer(queue.poll());
                rotation++;
            }
            if (rotation == queue.size()){
                break;
            }
        }
        return queue.size();
    }
}