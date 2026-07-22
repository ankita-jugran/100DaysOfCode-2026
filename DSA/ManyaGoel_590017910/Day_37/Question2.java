import java.util.*;
public class Question2 {
    public static int printTime (int[] arr, int location){
        Queue <Integer> priority = new LinkedList<>();
        Queue <Integer> index = new LinkedList<>();

        for(int i=0 ; i<arr.length ; i++){
            priority.offer(arr[i]);
            index.offer(i);
        }
        int minutes=0;

        while( !priority.isEmpty()){
            int current = priority.poll();
            int idx = index.poll();
            boolean max = false;

            for( int p : priority){
                if ( p > current){
                    max = true;
                    break;
                }
            }
            if( max ){
                priority.offer(current);
                index.offer( idx);
            }else{
                minutes++ ;
                if( idx == location ) return minutes;
            }
            }
        return minutes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of documents: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter document priorities:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.err.println(" Priorities: " + Arrays.toString(arr));

        System.out.print("Enter your document location: ");
        int location = sc.nextInt();

        System.out.println("Time required to print document is: " + printTime(arr, location) + " minute(s)");

        sc.close();
    }
}