import java.util.Stack;

public class Question_Leetcode {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>(); 

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                prices[st.peek()] -= prices[i];
                st.pop();
            }
            st.push(i);
        }
        return prices;
    }
}

