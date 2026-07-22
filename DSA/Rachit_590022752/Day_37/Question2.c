#include <stdio.h>
#define MAX 100

typedef struct {
    int priority;
    int index;
} Document;

int main() {
    int n, target;
    Document queue[MAX];
    int front = 0, rear = 0;
    int time = 0;

    printf("Enter number of documents: ");
    scanf("%d", &n);

    printf("Enter priorities of documents:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &queue[rear].priority);
        queue[rear].index = i;
        rear++;
    }

    printf("Enter target document position (0 to %d): ", n - 1);
    scanf("%d", &target);
    while (front < rear) {
        int highest = queue[front].priority;

        for (int i = front + 1; i < rear; i++) {
            if (queue[i].priority > highest)
                highest = queue[i].priority;
        }
        if (queue[front].priority < highest) {
            queue[rear] = queue[front];
            rear++;
            front++;
        }
        else {
            time++;

            if (queue[front].index == target) {
                printf("Document at position %d will be printed after %d minute(s).\n",
                       target, time);
                break;
            }

            front++;
        }
    }
    return 0;
}
