#include <stdio.h>
#define MAX 100

int stack1[MAX], stack2[MAX];
int top1 = -1, top2 = -1;

// Push into stack
void pushStack(int stack[], int *top, int x) {
    stack[++(*top)] = x;
}

// Pop from stack
int popStack(int stack[], int *top) {
    return stack[(*top)--];
}

// Check if stack is empty
int isEmptyStack(int top) {
    return top == -1;
}

// Push element into queue
void push(int x) {
    pushStack(stack1, &top1, x);
}
void transfer() {
    while (!isEmptyStack(top1)) {
        pushStack(stack2, &top2, popStack(stack1, &top1));
    }
}

// Peek front element
int peek() {
    if (isEmptyStack(top2))
        transfer();

    return stack2[top2];
}

// Pop front element
int pop() {
    if (isEmptyStack(top2))
        transfer();

    return popStack(stack2, &top2);
}

// Check if queue is empty
int empty() {
    return isEmptyStack(top1) && isEmptyStack(top2);
}

int main() {
    push(1);
    push(2);

    printf("Peek: %d\n", peek());
    printf("Pop: %d\n", pop());

    if (empty())
        printf("true\n");
    else
        printf("false\n");
    return 0;
}