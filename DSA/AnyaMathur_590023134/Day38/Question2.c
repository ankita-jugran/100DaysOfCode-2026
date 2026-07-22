// Problem 2
// The Card Trick

#include <stdio.h>
#define MAX 1000

typedef struct {
    int data[MAX];
    int front;
    int rear;
} Deque;

void insertFront(Deque *d, int card) {
    for(int i = d->rear; i > d->front; i--) {
        d->data[i] = d->data[i - 1];
    }
    d->data[d->front] = card;
    d->rear++;
}

void insertRear(Deque *d, int card) {
    d->data[d->rear] = card;
    d->rear++;
}

int deleteFront(Deque *d) {
    int card = d->data[d->front];
    for(int i = d->front; i < d->rear - 1; i++) {
        d->data[i] = d->data[i + 1];
    }
    d->rear--;
    return card;
}

int deleteRear(Deque *d) {
    d->rear--;
    return d->data[d->rear];
}

int main() {
    int n;
    printf("Enter number of cards: ");
    scanf("%d", &n);
    Deque d;
    d.front = 0;
    d.rear = 0;
    insertFront(&d, n);
    for(int i = n - 1; i >= 1; i--) {
        int temp = deleteRear(&d);
        insertFront(&d, temp);
        insertFront(&d, i);
    }
    printf("Initial arrangement: ");
    while(d.front < d.rear) {
        printf("%d ", deleteFront(&d));
    }
    return 0;
}