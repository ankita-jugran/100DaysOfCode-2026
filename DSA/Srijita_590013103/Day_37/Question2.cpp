class Solution {
public:
    int printerQueue(vector<int>& priorities, int location) {
        queue<pair<int, int>> q;

        for (int i = 0; i < priorities.size(); i++) {
            q.push({priorities[i], i});
        }

        int time = 0;

        while (!q.empty()) {
            auto current = q.front();
            q.pop();

            bool higher = false;

            queue<pair<int, int>> temp = q;

            while (!temp.empty()) {
                if (temp.front().first > current.first) {
                    higher = true;
                    break;
                }
                temp.pop();
            }

            if (higher) {
                q.push(current);
            } else {
                time++;

                if (current.second == location) {
                    return time;
                }
            }
        }

        return -1;
    }
};