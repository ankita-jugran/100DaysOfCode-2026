package Day81;

public class Question2 {
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
