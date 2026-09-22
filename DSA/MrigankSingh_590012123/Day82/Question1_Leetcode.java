package Day82;

public class Question1_Leetcode {
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num != 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num >>= 1;
            }

            steps++;
        }

        return steps;
    }
}
