/*Given an array representing the heights of people standing in a line, find the maximum number of people visible to any single person (including themselves).

Example
Input:arr[] = [6, 2, 5, 4, 5, 1, 6]. Output:6 */

package Day_34;
import java.util.Stack;
public class Question2 {
    public static int[] leftBlocker(int []arr){
        Stack<Integer> stack=new Stack<>();
        int[] leftblock=new int[arr.length];
        for (int  i=0; i<arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                leftblock[i]=-1;
            }
            else{
                leftblock[i]= stack.peek();
            }
            stack.push(i);
        }
        return leftblock;
    }
    public static int[] rightBlocker(int []arr){
        Stack<Integer> stack=new Stack<>();
        int[] rightblock=new int[arr.length];
        for (int  i=arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                rightblock[i]=arr.length;
            }
            else{
                rightblock[i]= stack.peek();
            }
            stack.push(i);
        }
        return rightblock;
    }
    public static int maximumVisible(int[] arr) {

        int[] left = leftBlocker(arr);
        int[] right = rightBlocker(arr);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int total = (i-left[i]-1) + (right[i]-i-1)+1;
            max = Math.max(max, total);
        }
        return max;
    }
}