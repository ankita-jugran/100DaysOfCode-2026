package Day82;

public class Question2 {
    public int turnOffRightmostSetBit(int n) {
        return n & (n - 1);
    }
}
