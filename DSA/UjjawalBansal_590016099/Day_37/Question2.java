import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayDeque;

public class Question2 {

    // This method uses a queue. Time: O(n), Space: O(n)
    public static int printerQueue(int[] arr, int location) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] frequency = new int[10];

        for (int i = 0; i < arr.length; i++) {
            q.offer(new int[] {arr[i], i});
            frequency[arr[i]]++;
        }

        int time = 0;
        int currMax = 9;

        while (!q.isEmpty()) {

            while (currMax > 0 && frequency[currMax] == 0) {
                currMax--;
            }

            int[] doc = q.poll();

            if (doc[0] == currMax) {
                time++;
                frequency[currMax]--;

                if (doc[1] == location) return time;
            }

            else q.offer(doc);
        }
        return time;
    }

    // This method uses a array to simulate a queue. Time: O(n), Space: O(1). It uses the input array as queue.
    public static int printerQueue2(int[] arr, int location) {
        int[] freq = new int[10];
        for (int p : arr) {
            freq[p]++;
        }
        
        int time = 0;
        int currMax = 9;
        int curr = 0;
        int n = arr.length;
        
        while (true) {
            
            while (currMax > 0 && freq[currMax] == 0) {
                currMax--;
            }
            
            if (arr[curr] == currMax) {
                time++;
                freq[currMax]--;
                
                if (curr == location) {
                    return time;
                }
                arr[curr] = 0; 
            }
            
            curr = (curr + 1) % n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of documents: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the document priorities: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the location of target document: ");
        int k = sc.nextInt();

        int ans = printerQueue(arr, k);
        int ans2 = printerQueue2(arr, k);

        System.out.println("Number of minutes until the target document is printer (using queue): " + ans);
        System.out.println("Number of minutes until the target document is printer (by simulating queue in an array): " + ans2);
        
        sc.close();
    }
}