#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int printerQueue(vector<int>& priorities, int location) {
    queue<pair<int, int>> q;
    priority_queue<int> maxHeap;

    // Store document priority and its original index
    for (int i = 0; i < priorities.size(); i++) {
        q.push({priorities[i], i});
        maxHeap.push(priorities[i]);
    }

    int minutes = 0;

    while (!q.empty()) {
        pair<int, int> current = q.front();
        q.pop();

        // If current document has the highest priority, print it
        if (current.first == maxHeap.top()) {
            minutes++;
            maxHeap.pop();

            if (current.second == location)
                return minutes;
        }
        // Otherwise, move it to the back of the queue
        else {
            q.push(current);
        }
    }

    return -1;
}

int main() {
    vector<int> priorities = {2, 1, 3, 2};
    int location = 2;

    cout << "Time taken to print the target document: "
         << printerQueue(priorities, location) << " minute(s)" << endl;

    return 0;
}