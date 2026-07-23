// Problem 2 
// Minimum Conference Rooms Required 

#include <stdio.h>
#define SIZE 100000

typedef struct {
    int start;
    int end;
} Meeting;

typedef struct {
    int heap[SIZE];
    int size;
} PriorityQueue;

void swapMeeting(Meeting *a, Meeting *b) {
    Meeting temp = *a;
    *a = *b;
    *b = temp;
}

void sort(Meeting meetings[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (meetings[j].start > meetings[j + 1].start) {
                swapMeeting(&meetings[j], &meetings[j + 1]);
            }
        }
    }
}

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void insert(PriorityQueue *pq, int value) {
    pq->heap[pq->size] = value;
    int i = pq->size;
    pq->size++;

    while (i > 0) {
        int parent = (i - 1) / 2;
        if (pq->heap[parent] > pq->heap[i]) {
            swap(&pq->heap[parent], &pq->heap[i]);
            i = parent;
        } else {
            break;
        }
    }
}

void delete(PriorityQueue *pq) {
    pq->heap[0] = pq->heap[pq->size - 1];
    pq->size--;

    int i = 0;

    while (i < pq->size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < pq->size && pq->heap[left] < pq->heap[smallest])
            smallest = left;
        if (right < pq->size && pq->heap[right] < pq->heap[smallest])
            smallest = right;
        if (smallest == i)
            break;
        swap(&pq->heap[i], &pq->heap[smallest]);
        i = smallest;
    }
}

int peek(PriorityQueue *pq) {
    return pq->heap[0];
}

int main() {
    int n;
    printf("Enter the number of meetings: ");
    scanf("%d", &n);

    Meeting meetings[SIZE];

    printf("Enter the meeting intervals: \n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &meetings[i].start, &meetings[i].end);
    }

    sort(meetings, n);
    PriorityQueue pq;
    pq.size = 0;

    for (int i = 0; i < n; i++) {
        if (pq.size > 0 && peek(&pq) <= meetings[i].start) {
            delete(&pq);
        }
        insert(&pq, meetings[i].end);
    }

    printf("Minimum Conference Rooms Required: %d ", pq.size);
    return 0;
}