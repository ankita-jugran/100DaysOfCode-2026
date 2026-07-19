// Leetcode Problem 232
// Implement Queue using Stacks 

#include <stdlib.h>
#include <stdbool.h>
#define SIZE 100

typedef struct {
    int inputStack[SIZE];
    int outputStack[SIZE];
    int inputTop;
    int outputTop;
} MyQueue;

MyQueue* myQueueCreate() {
    MyQueue *queue = (MyQueue *)malloc(sizeof(MyQueue));
    queue->inputTop = -1;
    queue->outputTop = -1;
    return queue;
}

void myQueuePush(MyQueue* obj, int x) {
    obj->inputTop++;
    obj->inputStack[obj->inputTop] = x;
}

int myQueuePop(MyQueue* obj) {
    if (obj->outputTop == -1) {
        while (obj->inputTop != -1) {
            obj->outputTop++;
            obj->outputStack[obj->outputTop] = obj->inputStack[obj->inputTop];
            obj->inputTop--;
        }
    }
    int front = obj->outputStack[obj->outputTop];
    obj->outputTop--;
    return front;
}

int myQueuePeek(MyQueue* obj) {
    if (obj->outputTop == -1) {
        while (obj->inputTop != -1) {
            obj->outputTop++;
            obj->outputStack[obj->outputTop] = obj->inputStack[obj->inputTop];
            obj->inputTop--;
        }
    }
    return obj->outputStack[obj->outputTop];
}

bool myQueueEmpty(MyQueue* obj) {
    return (obj->inputTop == -1 && obj->outputTop == -1);
}

void myQueueFree(MyQueue* obj) {
    free(obj);
}

/**
 * Your MyQueue struct will be instantiated and called as such:
 * MyQueue* obj = myQueueCreate();
 * myQueuePush(obj, x);
 
 * int param_2 = myQueuePop(obj);
 
 * int param_3 = myQueuePeek(obj);
 
 * bool param_4 = myQueueEmpty(obj);
 
 * myQueueFree(obj);
*/