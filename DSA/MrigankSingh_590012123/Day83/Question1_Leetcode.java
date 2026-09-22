package Day83;

public class Question1_Leetcode {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int x : nums) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }

        return ones;
    }
}
