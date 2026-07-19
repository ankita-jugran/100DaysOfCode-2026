


typedef struct {
    int s1[100];
    int s2[100];
    int top1;
    int top2;
} MyQueue;


MyQueue* myQueueCreate() {
    MyQueue* q=malloc(sizeof(MyQueue));
    q->top1=-1;
    q->top2=-1;
    return q;
}

void myQueuePush(MyQueue* obj, int x) {
    obj->s1[++obj->top1]=x;
}

int myQueuePop(MyQueue* obj) {
    if(obj->top2==-1){
        while(obj->top1!=-1){
            obj->s2[++obj->top2]=obj->s1[obj->top1--];
        }
    }
    return obj->s2[obj->top2--];
}

int myQueuePeek(MyQueue* obj) {
    if(obj->top2==-1){
        while(obj->top1!=-1){
            obj->s2[++obj->top2]=obj->s1[obj->top1--];
        }
    }
    return obj->s2[obj->top2];
}

bool myQueueEmpty(MyQueue* obj) {
    return obj->top1==-1 && obj->top2==-1;
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
