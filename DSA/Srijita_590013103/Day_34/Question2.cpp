class Solution {
public:
    int maxPeopleVisible(vector<int>& arr) {
        int n = arr.size();

        vector<int> left(n), right(n);
        stack<int> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] < arr[i])
                st.pop();

            left[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }

        while (!st.empty())
            st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] < arr[i])
                st.pop();

            right[i] = st.empty() ? n : st.top();
            st.push(i);
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = max(ans, right[i] - left[i] - 1);
        }

        return ans;
    }
};