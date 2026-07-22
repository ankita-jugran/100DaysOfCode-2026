// Leetcode Problem 933
// Number of Recent Calls  

typedef struct {
    int queue[10000];
    int front;
    int rear;
} RecentCounter;


RecentCounter* recentCounterCreate() {
    RecentCounter* obj = (RecentCounter*)malloc(sizeof(RecentCounter));
    obj->front = 0;
    obj->rear = 0;
    return obj;
}

int recentCounterPing(RecentCounter* obj, int t) {
    obj->queue[obj->rear] = t;
    obj->rear++;
    while (obj->queue[obj->front] < t - 3000) {
        obj->front++;
    }
    return obj->rear - obj->front;
}

void recentCounterFree(RecentCounter* obj) {
    free(obj);
}

/**
 * Your RecentCounter struct will be instantiated and called as such:
 * RecentCounter* obj = recentCounterCreate();
 * int param_1 = recentCounterPing(obj, t);
 
 * recentCounterFree(obj);
*/