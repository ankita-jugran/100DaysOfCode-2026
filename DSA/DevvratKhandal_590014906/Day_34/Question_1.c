#include <stdio.h>
#include <stdbool.h>

#define MAX 100

typedef struct {
    int s1[MAX];
    int s2[MAX];
    int top1;
    int top2;
} MyQueue;

void myQueueCreate(MyQueue *q) {
    q->top1 = -1;
    q->top2 = -1;
}

void myQueuePush(MyQueue *q, int x) {
    q->s1[++q->top1] = x;
}

void moveElements(MyQueue *q) {
    if (q->top2 == -1) {
        while (q->top1 != -1) {
            q->s2[++q->top2] = q->s1[q->top1--];
        }
    }
}

int myQueuePop(MyQueue *q) {
    moveElements(q);
    return q->s2[q->top2--];
}

int myQueuePeek(MyQueue *q) {
    moveElements(q);
    return q->s2[q->top2];
}

bool myQueueEmpty(MyQueue *q) {
    return q->top1 == -1 && q->top2 == -1;
}

int main() {
    MyQueue q;
    int n, x;

    myQueueCreate(&q);

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        myQueuePush(&q, x);
    }

    printf("Front element: %d\n", myQueuePeek(&q));
    printf("Removed element: %d\n", myQueuePop(&q));

    if (myQueueEmpty(&q))
        printf("Queue is empty\n");
    else
        printf("Queue is not empty\n");

    return 0;
}