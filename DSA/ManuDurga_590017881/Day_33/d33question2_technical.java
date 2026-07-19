package Day_33;

import java.util.*;

public class d33question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        Stack<String> stack = new Stack<>();

        for (char c : (sc.nextLine()).toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c + "");
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.push(c + b + a);
            }
        }

        System.out.println(stack.peek());
        sc.close();}
    }
