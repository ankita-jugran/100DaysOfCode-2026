package Day78;

public class Question2 {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    private TrieNode root;

    public int maximumXORPair(int[] arr) {
        root = new TrieNode();

        for (int x : arr) {
            insert(x);
        }

        int maximumXOR = 0;
        for (int x : arr) {
            maximumXOR = Math.max(maximumXOR, getMaximumXOR(x));
        }

        return maximumXOR;
    }

    private void insert(int num) {
        TrieNode cur = root;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;

            if (cur.child[b] == null) {
                cur.child[b] = new TrieNode();
            }

            cur = cur.child[b];
        }
    }

    private int getMaximumXOR(int num) {
        TrieNode cur = root;
        int ans = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            int opposite = 1 - b;

            if (cur.child[opposite] != null) {
                ans |= (1 << bit);
                cur = cur.child[opposite];
            } else {
                cur = cur.child[b];
            }
        }

        return ans;
    }
}
