
import java.util.*;
class PQ{
    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location = 1;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            q.offer(i);
        }
        int time = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            boolean canPrint = true;
            for(int i : q) {
                if (priorities[i] > priorities[current]){
                    canPrint = false;
                    break;
                }
            }
            if(canPrint){
                time++;
                if (current == location) {
                    System.out.println(time);
                    break;
                }
            } 
            else{
                q.offer(current);
            }
        }
    }
}