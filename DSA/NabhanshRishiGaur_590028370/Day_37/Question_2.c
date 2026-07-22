#include <stdio.h>

typedef struct {
    int priority;
    int index;
} Node;

int printerQueue(int priorities[], int n, int location) {
    Node q[100005];

    int front = 0, rear = n;

    for (int i = 0; i < n; i++) {
        q[i].priority = priorities[i];
        q[i].index = i;
    }

    int time = 0;

    while (front < rear) {
        Node cur = q[front++];
        int higher = 0;
      
        for (int i = front; i < rear; i++) {
            if (q[i].priority > cur.priority) {
                higher = 1;
                break;
            }
        }

        if (higher) {
            q[rear++] = cur;
        } else {
            time++;
            if (cur.index == location)
                return time;
        }
    }

    return -1;
}

int main() {
    int n, location;

    scanf("%d", &n);

    int priorities[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &priorities[i]);

    scanf("%d", &location);

    printf("%d\n", printerQueue(priorities, n, location));

    return 0;
}
