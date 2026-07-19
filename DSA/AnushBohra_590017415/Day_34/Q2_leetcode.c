#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 100

typedef struct {
    int* data;
    int top;
} Stack;

Stack* createStack() {
    Stack* s = (Stack*)malloc(sizeof(Stack));
    s->data = (int*)malloc(MAX_SIZE * sizeof(int));
    s->top = -1;
    return s;
}

void stackPush(Stack* s, int x) {
    s->data[++(s->top)] = x;
}

int stackPop(Stack* s) {
    return s->data[(s->top)--];
}

int stackPeek(Stack* s) {
    return s->data[s->top];
}

bool stackEmpty(Stack* s) {
    return s->top == -1;
}

void freeStack(Stack* s) {
    free(s->data);
    free(s);
}

typedef struct {
    Stack* inStack;
    Stack* outStack;
} MyQueue;

MyQueue* myQueueCreate() {
    MyQueue* obj = (MyQueue*)malloc(sizeof(MyQueue));
    obj->inStack = createStack();
    obj->outStack = createStack();
    return obj;
}

void myQueuePush(MyQueue* obj, int x) {
    stackPush(obj->inStack, x);
}

int myQueuePop(MyQueue* obj) {
    if (stackEmpty(obj->outStack)) {
        while (!stackEmpty(obj->inStack)) {
            stackPush(obj->outStack, stackPop(obj->inStack));
        }
    }
    return stackPop(obj->outStack);
}

int myQueuePeek(MyQueue* obj) {
    if (stackEmpty(obj->outStack)) {
        while (!stackEmpty(obj->inStack)) {
            stackPush(obj->outStack, stackPop(obj->inStack));
        }
    }
    return stackPeek(obj->outStack);
}

bool myQueueEmpty(MyQueue* obj) {
    return stackEmpty(obj->inStack) && stackEmpty(obj->outStack);
}

void myQueueFree(MyQueue* obj) {
    freeStack(obj->inStack);
    freeStack(obj->outStack);
    free(obj);
}

int main() {
    MyQueue* myQueue = myQueueCreate();
    
    myQueuePush(myQueue, 1);
    myQueuePush(myQueue, 2);
    
    printf("Peek: %d\n", myQueuePeek(myQueue)); 
    printf("Pop: %d\n", myQueuePop(myQueue));   
    printf("Empty: %s\n", myQueueEmpty(myQueue) ? "true" : "false"); 
    
    myQueueFree(myQueue);
    return 0;
}