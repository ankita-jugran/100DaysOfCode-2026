public class Question2 {
    int maxVisible(int[] a) {
        int n = a.length, r = 1;
        for (int i = 0; i < n; i++) {
            int c = 1, m = 0;
            for (int j = i - 1; j >= 0; j--)
                if (a[j] > m) { c++; m = a[j]; }
            m = 0;
            for (int j = i + 1; j < n; j++)
                if (a[j] > m) { c++; m = a[j]; }
            r = Math.max(r, c);
        } return r;
    }
}