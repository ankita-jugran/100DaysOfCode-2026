#include <stdio.h>
#define MAX 10000

typedef struct {
    int queue[MAX];
    int front;
    int rear;
} RecentCounter;

void init(RecentCounter *obj) {
    obj->front = 0;
    obj->rear = -1;
}

// Add a new request and return count of recent requests
int ping(RecentCounter *obj, int t) {
    obj->queue[++obj->rear] = t;

    // Remove requests older than t - 3000
    while (obj->front <= obj->rear && obj->queue[obj->front] < t - 3000) {
        obj->front++;
    }

    return obj->rear - obj->front + 1;
}

int main() {
    RecentCounter rc;
    init(&rc);

    printf("%d\n", ping(&rc, 1));
    printf("%d\n", ping(&rc, 100));
    printf("%d\n", ping(&rc, 3001));
    printf("%d\n", ping(&rc, 3002));

    return 0;
}