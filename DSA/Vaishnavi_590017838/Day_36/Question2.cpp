#include <iostream>
#include <queue>
using namespace std;

int ticketTime(int n, int k) {

    queue<int> people;

    for(int i = 1; i <= n; i++)
        people.push(i);

    int minute = 0;

    while(!people.empty()) {

        int current = people.front();
        people.pop();

        minute++;

        if(current == k)
            return minute;

        if(!people.empty() && people.front() % 2 != 0) {

            int frontPerson = people.front();
            people.pop();
            people.push(frontPerson);
        }
    }

    return minute;
}

int main() {

    int n, k;

    cout << "Enter the number of people: ";
    cin >> n;

    cout << "Enter the target person: ";
    cin >> k;

    cout << "Minute when person " << k
         << " gets the ticket: "
         << ticketTime(n, k);

    return 0;
}
