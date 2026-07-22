#include <iostream>
#include <deque>
#include <vector>
using namespace std;

vector<int> reconstructDeck(int n) {
    deque<int> dq;

    for (int i = n; i >= 1; i--) {

        if (!dq.empty()) {
            dq.push_front(dq.back());
            dq.pop_back();
        }

        dq.push_front(i);
    }

    return vector<int>(dq.begin(), dq.end());
}

int main() {
    int n = 4;

    vector<int> ans = reconstructDeck(n);

    for (int x : ans)
        cout << x << " ";

    return 0;
}
