#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
private:
    stack<int> s1, s2;

    void transfer() {
        while (!s1.empty()) {
            s2.push(s1.top());
            s1.pop();
        }
    }

public:
    void push(int x) {
        s1.push(x);
    }

    int pop() {
        if (s2.empty())
            transfer();

        int val = s2.top();
        s2.pop();
        return val;
    }

    int peek() {
        if (s2.empty())
            transfer();

        return s2.top();
    }

    bool empty() {
        return s1.empty() && s2.empty();
    }
};

int main() {
    MyQueue q;

    q.push(1);
    q.push(2);
    q.push(3);

    cout << q.peek() << endl;
    cout << q.pop() << endl;
    cout << q.peek() << endl;
    cout << q.empty() << endl;

    return 0;
}