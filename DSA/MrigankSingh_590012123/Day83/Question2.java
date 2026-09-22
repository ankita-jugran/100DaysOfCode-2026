package Day83;

public class Question2 {
    public int countSetBits(int n) {
        int count = 0;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }
}
