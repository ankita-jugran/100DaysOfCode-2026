package DSA.Mugdha_590015431.Day_34;
import java.util.*;

public class Question1_LeetCode {

    static class MyQueue {

        Stack<Integer> input;
        Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
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
            return input.isEmpty() && output.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);

        System.out.println(q.peek());   // 1
        System.out.println(q.pop());    // 1
        System.out.println(q.empty());  // false
    }
}
