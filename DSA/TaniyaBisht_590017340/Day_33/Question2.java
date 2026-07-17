
import java.util.Stack;
class Prefix{
    public static void main(String[] args) {
        String s = "ABC/-AK/L-*";
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                st.push(ch + "");
            }
            else {
                String op2 = st.pop();
                String op1 = st.pop();
                String temp = ch + op1 + op2;
                st.push(temp);
            }
        }
        System.out.println("Postfix: " + s);
        System.out.println("Prefix : " + st.peek());
    }
}