#include <stdio.h>
#include <stdlib.h>

#define MAX 1000

typedef struct {
    int inStack[MAX];
    int outStack[MAX];
    int topIn;
    int topOut;
} MyQueue;

void init(MyQueue *q) {
    q->topIn = -1;
    q->topOut = -1;
}

void push(MyQueue *q, int x) {
    q->inStack[++q->topIn] = x;
}

int pop(MyQueue *q) {
    if (q->topOut == -1) {
        while (q->topIn != -1)
            q->outStack[++q->topOut] = q->inStack[q->topIn--];
    }
    return q->outStack[q->topOut--];
}

int peek(MyQueue *q) {
    if (q->topOut == -1) {
        while (q->topIn != -1)
            q->outStack[++q->topOut] = q->inStack[q->topIn--];
    }
    return q->outStack[q->topOut];
}

int empty(MyQueue *q) {
    return (q->topIn == -1 && q->topOut == -1);
}

int main() {
    MyQueue q;
    init(&q);

    push(&q, 1);
    push(&q, 2);
    push(&q, 3);

    printf("Front Element: %d\n", peek(&q));
    printf("Popped: %d\n", pop(&q));
    printf("Front Element: %d\n", peek(&q));

    if (empty(&q))
        printf("Queue is Empty\n");
    else
        printf("Queue is Not Empty\n");

    return 0;
}