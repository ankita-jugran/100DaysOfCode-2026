package DSA.TanmaySharma_590011578.Day_34;
import java.util.Stack;

public class Question2 {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public Question2() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        if (input.isEmpty() && output.isEmpty()) {
            return true;
        }
        return false;
    }
}