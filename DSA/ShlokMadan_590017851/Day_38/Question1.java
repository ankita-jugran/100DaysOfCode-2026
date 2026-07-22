import java.util.LinkedList;
import java.util.Queue;
public class Question1 
{
    public static int countStudents(int[] students,int[] sandwiches) 
    {

        Queue<Integer> q=new LinkedList<>();
        for(int s:students) 
            {
            q.offer(s);
        }
        int index=0;
        int count=0;
        while(!q.isEmpty() && count<q.size()) 
            {
            if(q.peek()==sandwiches[index]) 
                {
                q.poll();
                index++;
                count=0;
            }
            else 
                {
                q.offer(q.poll());
                count++;
            }
        }
        return q.size();
    }
    public static void main(String[] args) 
    {
        int[] students={1,1,0,0};
        int[] sandwiches={0,1,0,1};
        System.out.println(countStudents(students,sandwiches));
    }
}