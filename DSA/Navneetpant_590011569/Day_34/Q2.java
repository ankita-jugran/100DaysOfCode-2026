class Solution {
    public int maxPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] leftBlock = new int[n];
        int[] rightBlock = new int[n];

        Stack<Integer> st = new Stack<>();


        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            leftBlock[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            rightBlock[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            int leftVisible = i - leftBlock[i] - 1;
            int rightVisible = rightBlock[i] - i - 1;

            ans = Math.max(ans, leftVisible + rightVisible + 1);
        }

        return ans;
    }