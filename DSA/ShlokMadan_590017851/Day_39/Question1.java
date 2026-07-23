public class Question1 
{
    public static int timeRequiredToBuy(int[] tickets,int k) 
    {
        int time=0;
        for(int i=0;i<tickets.length;i++) 
            {
            if(i<=k) 
                {
                time+=Math.min(tickets[i],tickets[k]);
            }
            else 
                {
                time+=Math.min(tickets[i],tickets[k]-1);
            }
        }
        return time;
    }
    public static void main(String[] args) 
    {
        int[] tickets={2,3,2};
        int k=2;
        System.out.println(timeRequiredToBuy(tickets,k));
    }
}