#include <stdio.h>

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    int q[1005];
    int front = 0, rear = 0;

    for (int i = 1; i <= n; i++)
        q[rear++] = i;

    int minute = 0;

    while (front != rear) {
        // Serve the front person
        int person = q[front];
        front = (front + 1) % 1005;
        minute++;

        if (person == k) {
            printf("%d\n", minute);
            return 0;
        }

        // Move the next front person to the back if odd
        if (front != rear) {
            int next = q[front];
            if (next % 2 == 1) {
                front = (front + 1) % 1005;
                q[rear] = next;
                rear = (rear + 1) % 1005;
            }
        }
    }

    return 0;
}
