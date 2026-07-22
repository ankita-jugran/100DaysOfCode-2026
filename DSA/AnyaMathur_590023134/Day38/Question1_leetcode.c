// Leetcode Problem 1700
// Number of Students Unable to Eat Lunch

#define MAX 101

typedef struct {
    int queue[MAX];
    int front;
    int rear;
} Queue;

void enqueue(Queue *q, int value) {
    q->queue[q->rear % MAX] = value;
    q->rear++;
}

int dequeue(Queue *q) {
    int value = q->queue[q->front % MAX];
    q->front++;
    return value;
}

int countStudents(int* students, int studentsSize, int* sandwiches, int sandwichesSize) {
    Queue q;
    q.front = 0;
    q.rear = 0;
    for(int i = 0; i < studentsSize; i++) {
        enqueue(&q, students[i]);
    }
    int sandwich = 0;
    int count = 0;
    while(q.front < q.rear) {
        int student = dequeue(&q);
        if(student == sandwiches[sandwich]) {
            sandwich++;
            count = 0;
        }
        else {
            enqueue(&q, student);
            count++;
        }
        if(count >= q.rear - q.front) {
            break;
        }
    }
    return q.rear - q.front;
}