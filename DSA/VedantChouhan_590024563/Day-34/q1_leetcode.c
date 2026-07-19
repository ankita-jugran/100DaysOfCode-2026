#include <stdio.h>

#define MAX 100

struct Stack {
    int arr[MAX];
    int top;
};

void pushStack(struct Stack *s, int x) {
    s->arr[++(s->top)] = x;
}

int popStack(struct Stack *s) {
    return s->arr[(s->top)--];
}

int peekStack(struct Stack *s) {
    return s->arr[s->top];
}

int isEmptyStack(struct Stack *s) {
    return s->top == -1;
}

struct MyQueue {
    struct Stack stack1;
    struct Stack stack2;
};

void initQueue(struct MyQueue *q) {
    q->stack1.top = -1;
    q->stack2.top = -1;
}

void push(struct MyQueue *q, int x) {
    pushStack(&q->stack1, x);
}

void transfer(struct MyQueue *q) {
    while (!isEmptyStack(&q->stack1)) {
        pushStack(&q->stack2, popStack(&q->stack1));
    }
}

int pop(struct MyQueue *q) {
    if (isEmptyStack(&q->stack2))
        transfer(q);

    return popStack(&q->stack2);
}

int peek(struct MyQueue *q) {
    if (isEmptyStack(&q->stack2))
        transfer(q);

    return peekStack(&q->stack2);
}

int empty(struct MyQueue *q) {
    return isEmptyStack(&q->stack1) && isEmptyStack(&q->stack2);
}

int main() {

    struct MyQueue q;
    initQueue(&q);

    push(&q, 1);
    push(&q, 2);

    printf("Peek: %d\n", peek(&q));
    printf("Pop: %d\n", pop(&q));
    printf("Empty: %s\n", empty(&q) ? "true" : "false");

    push(&q, 3);

    printf("Pop: %d\n", pop(&q));
    printf("Pop: %d\n", pop(&q));
    printf("Empty: %s\n", empty(&q) ? "true" : "false");

    return 0;
}