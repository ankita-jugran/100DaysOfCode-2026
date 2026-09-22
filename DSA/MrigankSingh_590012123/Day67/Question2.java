package Day67;

public class Question2 {
    private int cntM1;
    private int cnt0;
    private int cntP1;

    public int[] balanceSpectrum(int[] arr) {
        cntM1 = 0;
        cnt0 = 0;
        cntP1 = 0;
        build(arr, 0, arr.length - 1);
        return new int[]{cntM1, cnt0, cntP1};
    }

    private int build(int[] arr, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        int leftH = build(arr, l, mid - 1);
        int rightH = build(arr, mid + 1, r);

        int bf = rightH - leftH;
        if (bf == -1) {
            cntM1++;
        } else if (bf == 0) {
            cnt0++;
        } else if (bf == 1) {
            cntP1++;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
