import java.util.Stack;

class Solution {

    public String postToPre(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                st.push(String.valueOf(ch));
            }
            else {
                String op2 = st.pop();
                String op1 = st.pop();

                String temp = ch + op1 + op2;
                st.push(temp);
            }
        }
        return st.pop();
    }
}