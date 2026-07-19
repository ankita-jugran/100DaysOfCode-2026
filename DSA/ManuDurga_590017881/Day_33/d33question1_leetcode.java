package Day_33;

import java.util.*;
public class d33question1_leetcode {
    
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0)
                    ans.append(c);
                count++;
            } else {
                count--;
                if (count > 0)
                    ans.append(c);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        System.out.print(removeOuterParentheses(sc.nextLine()));
        sc.close();
    }
}
