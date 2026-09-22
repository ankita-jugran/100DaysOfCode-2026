package Day57;

public class Question2 {
    public boolean isMirror(long[] a, long[] b, int i, int j) {
        if ((i >= a.length || a[i] == -1) && (j >= b.length || b[j] == -1)) {
            return true;
        }

        if (i >= a.length || a[i] == -1 || j >= b.length || b[j] == -1) {
            return false;
        }

        if (a[i] != b[j]) {
            return false;
        }

        return isMirror(a, b, 2 * i + 1, 2 * j + 2) &&
               isMirror(a, b, 2 * i + 2, 2 * j + 1);
    }
}
