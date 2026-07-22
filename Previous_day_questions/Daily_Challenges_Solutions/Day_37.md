<h2 align="center">Week 6 Day 37 (21/07/2026)</h2>

## 1. Number of Recent Calls (LeetCode #933)

### Solution
```c
#include <stdlib.h>

#define MAXSIZE 10005

typedef struct {
    int data[MAXSIZE];
    int front, rear, size;
} Queue;

void initQueue(Queue *q) {
    q->front = 0;
    q->rear = -1;
    q->size = 0;
}

void enqueue(Queue *q, int x) {
    q->rear = (q->rear + 1) % MAXSIZE;
    q->data[q->rear] = x;
    q->size++;
}

int dequeue(Queue *q) {
    int val = q->data[q->front];
    q->front = (q->front + 1) % MAXSIZE;
    q->size--;
    return val;
}

int peekFront(Queue *q) {
    return q->data[q->front];
}

typedef struct {
    Queue q;
} RecentCounter;

// Initialize the counter (starts empty)
void recentCounterInit(RecentCounter *rc) {
    initQueue(&rc->q);
}

// Push t, then pop all timestamps older than t - 3000, return window size
int recentCounterPing(RecentCounter *rc, int t) {
    enqueue(&rc->q, t);
    while (peekFront(&rc->q) < t - 3000) {
        dequeue(&rc->q);
    }
    return rc->q.size;
}

/**
 * Your RecentCounter struct will be instantiated and called as such:
 * RecentCounter rc;
 * recentCounterInit(&rc);
 * int result = recentCounterPing(&rc, t);
 */
```

### Approach
Maintain a queue of timestamps. On each `ping(t)`, push `t`, then pop every timestamp from the front that is smaller than `t - 3000`. The final queue size is the number of pings within the last 3000 ms window. Since every timestamp is pushed and popped at most once, the algorithm runs in **O(1) amortized time per call**, **O(n) space** in the worst case.

---

## 2. Printer Queue

### Solution
```c
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int priority;
    int index;
} Doc;

int printerQueue(int *priorities, int n, int location) {
    // Capacity n is sufficient: documents only cycle, never duplicate
    Doc *queue = (Doc *)malloc(n * sizeof(Doc));
    int front = 0, rear = n - 1, size = n;

    for (int i = 0; i < n; i++) {
        queue[i].priority = priorities[i];
        queue[i].index = i;
    }

    // count of each priority (1-9) still waiting in the queue
    int count[10] = {0};
    for (int i = 0; i < n; i++) {
        count[priorities[i]]++;
    }

    int minutes = 0;

    while (size > 0) {
        Doc d = queue[front];
        front = (front + 1) % n;
        size--;

        // find current max priority in O(9)
        int maxPriority = 0;
        for (int p = 9; p >= 1; p--) {
            if (count[p] > 0) { maxPriority = p; break; }
        }

        if (d.priority < maxPriority) {
            // move to back of the queue
            rear = (rear + 1) % n;
            queue[rear] = d;
            size++;
        } else {
            // print it
            minutes++;
            count[d.priority]--;
            if (d.index == location) {
                free(queue);
                return minutes;
            }
        }
    }

    free(queue);
    return -1; // unreachable if location is valid
}

int main() {
    int priorities[] = {2, 1, 3, 2};
    int n = sizeof(priorities) / sizeof(priorities[0]);
    int location = 2;
    printf("Minute printed: %d\n", printerQueue(priorities, n, location));
    return 0;
}
```

### Approach
Simulate the queue of `{priority, original_index}` pairs. Repeatedly pop the front:
- If a document with **strictly higher priority** still remains in the queue, move the front document to the back.
- Otherwise, print it (increment the minute counter, remove it). If its index equals `location`, return the answer.

Since priorities are bounded to **1–9**, a `count[10]` array tracks how many documents of each priority remain, so the current maximum priority can be found in **O(9)** instead of scanning the whole queue. This gives **O(n)** overall time (constant factor 9) and **O(n)** space.

**Verified against samples:**
- `[2,1,3,2]`, location=2 → `1` ✓
- `[1,1,9,1,1,1]`, location=0 → `5` ✓
- `[2,4,3,2,1]`, location=2 → `2` ✓
