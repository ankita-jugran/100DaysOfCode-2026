int maxVisible(int[] arr) {
    int n = arr.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Stack<Integer> st = new Stack<>();

    // Visible to the left
    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && arr[st.peek()] < arr[i])
            st.pop();

        left[i] = st.isEmpty() ? i : i - st.peek();
        st.push(i);
    }

    st.clear();

    // Visible to the right
    for (int i = n - 1; i >= 0; i--) {
        while (!st.isEmpty() && arr[st.peek()] < arr[i])
            st.pop();

        right[i] = st.isEmpty() ? n - 1 - i : st.peek() - i;
        st.push(i);
    }

    int ans = 0;
    for (int i = 0; i < n; i++)
        ans = Math.max(ans, left[i] + right[i] + 1);

    return ans;
}