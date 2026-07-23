import java.util.Arrays;
import java.util.PriorityQueue;
public class Question2 
{
    public static int minMeetingRooms(int[][] intervals) 
    {
        if(intervals.length==0) 
            {
            return 0;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i=1;i<intervals.length;i++) 
            {
            if(intervals[i][0]>=pq.peek()) 
                {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
    public static void main(String[] args) 
    {
        int[][] intervals={
            {0,30},
            {5,10},
            {15,20}
        };
        System.out.println(minMeetingRooms(intervals));
    }
}