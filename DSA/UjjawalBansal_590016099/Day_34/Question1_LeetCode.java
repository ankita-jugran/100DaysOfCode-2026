import java.util.ArrayDeque;
import java.util.Deque;

public class Question1_LeetCode {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public Question1_LeetCode() {  // The constructor was originally named MyQueue but as it should match the class name, I changed it to Question1_LeetCode. The class was named this as it should match the file name.
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    private void inputToOutput(){
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        if (stack2.isEmpty()) inputToOutput();
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()) inputToOutput();
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
