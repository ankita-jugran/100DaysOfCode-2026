/*The Card Trick
Explanation
Given n, reconstruct the initial deck arrangement such that revealing the top card and moving the next to the bottom repeatedly produces cards in order 1 to n.

Example
Input: n = 4. Output: [1, 3, 2, 4] */
package Day_38;
import java.util.*;
public class Question2 {
    public int[] card(int n){
        Deque<Integer> dq=new ArrayDeque<>();
        for (int i=n; i>=1; i--){
            if(!dq.isEmpty()){
                int last=dq.pollLast();
                dq.offerFirst(last);
            }
            dq.offerFirst(i);
        }
        int[] ans = new int[n];
        for (int i=0; i<n;i++){
            ans[i]=dq.pollFirst();
        }
        return ans;
    }
}
