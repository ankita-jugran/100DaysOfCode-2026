#include <iostream>
#include <vector>
using namespace std;

int maxVisiblePeople(vector<int>& arr) {
    int n = arr.size();
    int ans = 0;

    for (int i = 0; i < n; i++) {
        int visible = 1;

        int leftMax = arr[i];
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] >= leftMax) {
                visible++;
                leftMax = arr[j];
            }
        }

        int rightMax = arr[i];
        for (int j = i + 1; j < n; j++) {
            if (arr[j] >= rightMax) {
                visible++;
                rightMax = arr[j];
            }
        }

        ans = max(ans, visible);
    }

    return ans;
}

int main() {
    vector<int> arr = {6, 2, 5, 4, 5, 1, 6};

    cout << maxVisiblePeople(arr);

    return 0;
}