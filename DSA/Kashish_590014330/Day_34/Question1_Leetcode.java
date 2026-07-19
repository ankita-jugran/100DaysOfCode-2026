import java.util.Scanner;
import java.util.Stack;

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

public class Question1_Leetcode {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            q.push(x);
        }

        System.out.println("Front Element: " + q.peek());
        System.out.println("Removed: " + q.pop());
        System.out.println("Front Element after pop: " + q.peek());
        System.out.println("Is Queue Empty? " + q.empty());

        sc.close();
    }
}