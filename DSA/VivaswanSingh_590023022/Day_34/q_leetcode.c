typedef struct
{
    int input[100];
    int output[100];
    int top1;
    int top2;
} MyQueue;

MyQueue* myQueueCreate()
{
    MyQueue *obj = (MyQueue *)malloc(sizeof(MyQueue));
    obj->top1 = -1;
    obj->top2 = -1;
    return obj;
}

void myQueuePush(MyQueue* obj, int x)
{
    obj->input[++obj->top1] = x;
}

int myQueuePop(MyQueue* obj)
{
    if (obj->top2 == -1)
    {
        while (obj->top1 != -1)
        {
            obj->output[++obj->top2] = obj->input[obj->top1--];
        }
    }

    return obj->output[obj->top2--];
}

int myQueuePeek(MyQueue* obj)
{
    if (obj->top2 == -1)
    {
        while (obj->top1 != -1)
        {
            obj->output[++obj->top2] = obj->input[obj->top1--];
        }
    }

    return obj->output[obj->top2];
}

bool myQueueEmpty(MyQueue* obj)
{
    return (obj->top1 == -1 && obj->top2 == -1);
}

void myQueueFree(MyQueue* obj)
{
    free(obj);
}