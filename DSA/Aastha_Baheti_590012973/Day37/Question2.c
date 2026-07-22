#include <stdio.h>

typedef struct {
    int priority;
    int index;
} Document;

int printerQueue(int priorities[], int n, int location) {
    Document queue[100000];
    int front = 0, rear = 0;

    // Initialize queue
    for (int i = 0; i < n; i++) {
        queue[rear].priority = priorities[i];
        queue[rear].index = i;
        rear++;
    }

    int time = 0;

    while (front < rear) {
        Document current = queue[front++];
        int higher = 0;

        // Check if any remaining document has higher priority
        for (int i = front; i < rear; i++) {
            if (queue[i].priority > current.priority) {
                higher = 1;
                break;
            }
        }

        if (higher) {
            // Move current document to the back
            queue[rear++] = current;
        } else {
            // Print the document
            time++;
            if (current.index == location)
                return time;
        }
    }

    return -1;
}

int main() {
    int n, location;

    scanf("%d", &n);

    int priorities[100000];

    for (int i = 0; i < n; i++)
        scanf("%d", &priorities[i]);

    scanf("%d", &location);

    printf("%d\n", printerQueue(priorities, n, location));

    return 0;
}