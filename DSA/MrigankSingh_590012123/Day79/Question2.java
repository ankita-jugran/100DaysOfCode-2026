package Day79;

public class Question2 {
    public int findSingleNumber(int[] nums) {
        int ans = 0;

        for (int x : nums) {
            ans ^= x;
        }

        return ans;
    }
}
