import java.util.*;
class main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

       int arr[]=new int[n];
       
       for(int i=0; i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       int ans=1;

       for(int i=0;i<n;i++)
       {
        int visible=1;
        int tallest=0;

        for(int j=i-1;j>=0;j--)
        {
            if(arr[j] > tallest)
            {
                visible++;
                tallest=arr[j];
            }
            if(arr[j] >= arr[i])
            {
                break;
            }
        }
       }
        tallest=0;
        for(int j=i+1;j<n;j++)
        {
            if(arr[j] > tallest)
            {
                visible++;
                tallest=arr[i];
            }
            if(arr[j] >=arr[i])
            {
                break;
            }
        }
        if(visible > ans)
        {
            ans=visible;
        }
    }
    System.out.println(ans);
}