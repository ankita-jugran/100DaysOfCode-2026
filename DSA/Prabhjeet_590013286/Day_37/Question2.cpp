//Need to simulate the priority based printer queue

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<int> priorities = {2, 1, 3, 2};
    int location = 2;

    queue<pair<int, int>> q;

    for (int i = 0; i < priorities.size(); i++)
    {
        q.push({priorities[i], i});
    }

    int minutes = 0;

    while (!q.empty())
    {
        pair<int, int> current = q.front();
        q.pop();

        bool hasHigherPriority = false;

        queue<pair<int, int>> temp = q;

        while (!temp.empty())
        {
            if (temp.front().first > current.first)
            {
                hasHigherPriority = true;
                break;
            }
            temp.pop();
        }

        if (hasHigherPriority)
        {
            q.push(current);
        }
        else
        {
            minutes++;

            if (current.second == location)
            {
                cout << minutes;
                break;
            }
        }
    }

    return 0;
}