#include <iostream>
#include <queue>
using namespace std;

class RecentCounter {
private:
    queue<int> q;

public:
    RecentCounter() {}

    int ping(int t) {
        q.push(t);

        while (!q.empty() && q.front() < t - 3000) {
            q.pop();
        }

        return q.size();
    }
};

int main() {
    RecentCounter recentCounter;

    cout << recentCounter.ping(1) << endl;      // 1
    cout << recentCounter.ping(100) << endl;    // 2
    cout << recentCounter.ping(3001) << endl;   // 3
    cout << recentCounter.ping(3002) << endl;   // 3

    return 0;
}