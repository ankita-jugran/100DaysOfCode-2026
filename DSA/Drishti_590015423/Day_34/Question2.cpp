#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int maxVisiblePeople(vector<int> &arr)
{
    int n = arr.size();

    vector<int> left(n, 0);
    vector<int> right(n, 0);

    stack<int> st;

    // Count visible people on the left
    for (int i = 0; i < n; i++)
    {
        while (!st.empty() && arr[st.top()] < arr[i])
        {
            left[i]++;
            st.pop();
        }

        if (!st.empty())
            left[i++;

        st.push(i);
    }

    while (!st.empty())
        st.pop();

    // Count visible people on the right
    for (int i = n - 1; i >= 0; i--)
    {
        while (!st.empty() && arr[st.top()] < arr[i])
        {
            right[i]++;
            st.pop();
        }

        if (!st.empty())
            right[i]++;

        st.push(i);
    }

    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        ans = max(ans, left[i] + right[i] + 1);
    }

    return ans;
}

int main()
{
    vector<int> arr = {6, 2, 5, 4, 5, 1, 6};

    cout << "Maximum visible people = "
         << maxVisiblePeople(arr);

    return 0;
}
