#define MAXSIZE 100
typedef struct {
   int stack1[MAXSIZE]; 
    int top1;
    int stack2[MAXSIZE];   
    int top2; 
} MyQueue;
MyQueue* myQueueCreate() {
     MyQueue* obj = (MyQueue*)malloc(sizeof(MyQueue));
    obj->top1 = -1;
    obj->top2 = -1;  
    return obj;
}
void myQueuePush(MyQueue* obj, int x) {
     obj->top1++;
    obj->stack1[obj->top1] = x;
}
int myQueuePop(MyQueue* obj) {
      if (obj->top2 == -1) {
        while (obj->top1 != -1) {
            obj->top2++;
            obj->stack2[obj->top2] = obj->stack1[obj->top1];
            obj->top1--;
        }
    }
    int front = obj->stack2[obj->top2];
    obj->top2--;
    return front;
}
int myQueuePeek(MyQueue* obj) {
     if (obj->top2 == -1) {
        while (obj->top1 != -1) {
            obj->top2++;
            obj->stack2[obj->top2] = obj->stack1[obj->top1];
            obj->top1--;
        }
    }
    return obj->stack2[obj->top2];
}
bool myQueueEmpty(MyQueue* obj) {
    return obj->top1 == -1 && obj->top2 == -1; 
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