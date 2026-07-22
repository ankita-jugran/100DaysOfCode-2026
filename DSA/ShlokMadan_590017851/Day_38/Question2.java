import java.util.ArrayDeque;
import java.util.Deque;
public class Question2 
{
    public static int[] arrangeDeck(int n) 
    {
        Deque<Integer> deck=new ArrayDeque<>();
        for(int i=n;i>=1;i--) 
            {
            if(!deck.isEmpty()) 
                {
                deck.addFirst(deck.removeLast());
            }
            deck.addFirst(i);
        }
        int[] ans=new int[n];
        int i=0;
        while(!deck.isEmpty()) {
            ans[i++]=deck.removeFirst();
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int n=4;
        int[] ans=arrangeDeck(n);
        System.out.print("[");
        for(int i=0;i<ans.length;i++) 
            {
            System.out.print(ans[i]);
            if(i!=ans.length-1) 
                {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}