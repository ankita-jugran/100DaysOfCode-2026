package Day80;

public class Question2 {
    public boolean isPowerOfTwoOrZero(int n) {
        return n == 0 || (n & (n - 1)) == 0;
    }
}
