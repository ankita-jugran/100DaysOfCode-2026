import java.util.Stack;
public class Question2 
{
    static int maxVisible(int[] arr) 
    {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) 
            {
            while(!st.isEmpty() && arr[st.peek()]<arr[i]) 
                {
                st.pop();
            }
            if(st.isEmpty())
                left[i]=i;
            else
                left[i]=i-st.peek();

            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--) 
            {
            while(!st.isEmpty() && arr[st.peek()]<arr[i]) 
                {
                st.pop();
            }
            if(st.isEmpty())
                right[i]=n-1-i;
            else
                right[i]=st.peek()-i;

            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++) 
            {
            ans=Math.max(ans,left[i]+right[i]+1);
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] arr={6,2,5,4,5,1,6};
        System.out.println(maxVisible(arr));
    }
}