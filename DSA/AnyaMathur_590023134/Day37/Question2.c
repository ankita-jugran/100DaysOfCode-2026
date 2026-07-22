// Problem 2 
// Printer Queue  

#include <stdio.h>
#define MAX 100000

typedef struct {
    int priority;
    int index;
} Document;

typedef struct {
    Document queue[MAX];
    int front;
    int rear;
} Queue;

void enqueue(Queue *q, Document doc) {
    q->queue[q->rear] = doc;
    q->rear++;
}

Document dequeue(Queue *q) {
    return q->queue[q->front++];
}

int printerQueue(int priorities[], int n, int location) {
    Queue q;
    q.front = 0;
    q.rear = 0;

    for(int i = 0; i < n; i++) {
        Document doc;
        doc.priority = priorities[i];
        doc.index = i;
        enqueue(&q, doc);
    }

    int time = 0;

    while(q.front < q.rear) {
        Document doc = dequeue(&q);
        int print = 1;
        for(int i = q.front; i < q.rear; i++) {
            if(q.queue[i].priority > doc.priority) {
                print = 0;
                break;
            }
        }
        if(print == 1) {
            time++;
            if(doc.index == location)
                return time;
        }
        else {
            enqueue(&q, doc);
        }
    }
    return time;
}

int main() {
    int n, location;
    printf("Enter number of documents: ");
    scanf("%d", &n);
    int priorities[MAX];
    printf("Enter priorities: ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &priorities[i]);
    }
    printf("Enter location: ");
    scanf("%d", &location);
    printf("Time taken to print your document: %d", printerQueue(priorities, n, location));
    return 0;
}