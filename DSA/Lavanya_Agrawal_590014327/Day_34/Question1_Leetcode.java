import java.util.*;

public class Question1_Leetcode {

    static class MyQueue {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

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

        Scanner sc = new Scanner(System.in);

        String operationsLine = sc.nextLine();
        String valuesLine = sc.nextLine();

        operationsLine = operationsLine.replaceAll("[\\[\\]\"]", "");
        String[] operations = operationsLine.split(",\\s*");

        List<Integer> values = new ArrayList<>();

        StringBuilder num = new StringBuilder();
        for (char ch : valuesLine.toCharArray()) {
            if (Character.isDigit(ch) || ch == '-') {
                num.append(ch);
            } else {
                if (num.length() > 0) {
                    values.add(Integer.parseInt(num.toString()));
                    num.setLength(0);
                }
            }
        }

        MyQueue queue = new MyQueue();

        int valueIndex = 0;

        System.out.print("[");

        for (int i = 0; i < operations.length; i++) {

            String op = operations[i].trim();

            switch (op) {
                case "MyQueue":
                    System.out.print("null");
                    break;

                case "push":
                    queue.push(values.get(valueIndex++));
                    System.out.print("null");
                    break;

                case "pop":
                    System.out.print(queue.pop());
                    break;

                case "peek":
                    System.out.print(queue.peek());
                    break;

                case "empty":
                    System.out.print(queue.empty());
                    break;
            }

            if (i != operations.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        sc.close();
    }
}