#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int printTime(vector<int>& priorities, int location) {
    queue<pair<int, int>> documents;
    for(int i = 0; i < priorities.size(); i++)
        documents.push({priorities[i], i});
    int minutes = 0;
    while(!documents.empty()) {
        pair<int, int> current = documents.front();
        documents.pop();
        bool higherPriority = false;
        queue<pair<int, int>> temp = documents;
        while(!temp.empty()) {
            if(temp.front().first > current.first) {
                higherPriority = true;
                break;
            }
            temp.pop();
        }
        if(higherPriority) {
            documents.push(current);
        }
        else {
            minutes++;
            if(current.second == location)
                return minutes;
        }
    }
    return minutes;
}

int main() {
    int n;
    cout << "Enter the number of documents: ";
    cin >> n;
    vector<int> priorities(n);
    cout << "Enter document priorities: ";
    for(int i = 0; i < n; i++)
        cin >> priorities[i];

    int location;
    cout << "Enter your document position: ";
    cin >> location;

    cout << "Time taken to print: "
         << printTime(priorities, location);
    return 0;
}
