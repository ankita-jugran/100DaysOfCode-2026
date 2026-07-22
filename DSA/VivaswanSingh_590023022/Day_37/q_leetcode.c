#define MAX 10000

typedef struct
{
    int queue[MAX];
    int front;
    int rear;
} RecentCounter;

RecentCounter* recentCounterCreate()
{
    RecentCounter* obj = (RecentCounter*)malloc(sizeof(RecentCounter));
    obj->front = 0;
    obj->rear = 0;
    return obj;
}

int recentCounterPing(RecentCounter* obj, int t)
{
    obj->queue[obj->rear++] = t;

    while (obj->queue[obj->front] < t - 3000)
    {
        obj->front++;
    }

    return obj->rear - obj->front;
}

void recentCounterFree(RecentCounter* obj)
{
    free(obj);
}