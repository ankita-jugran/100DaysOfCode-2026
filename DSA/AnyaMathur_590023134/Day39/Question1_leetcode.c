// Leetcode Problem 2073
// Time Needed to Buy Tickets 

#define SIZE 101

typedef struct {
    int queue[SIZE];
    int front;
    int rear;
} Queue;

void enqueue(Queue *q, int value) {
    q->queue[q->rear % SIZE] = value;
    q->rear++;
}

int dequeue(Queue *q) {
    int value = q->queue[q->front % SIZE];
    q->front++;
    return value;
}

int isEmpty(Queue *q) {
    return q->front == q->rear;
}

int timeRequiredToBuy(int* tickets, int ticketsSize, int k) {
    Queue q;
    q.front = 0;
    q.rear = 0;
    for (int i = 0; i < ticketsSize; i++) {
        enqueue(&q, i);
    }
    int time = 0;
    while (q.front != q.rear) {
        int person = dequeue(&q);
        tickets[person]--;
        time++;
        if (tickets[person] > 0) {
            enqueue(&q, person);
        }
        if (person == k && tickets[person] == 0) {
            return time;
        }
    }
    return time;
}