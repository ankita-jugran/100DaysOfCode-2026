<h2 align="center">Week 5 Day 34 (18/07/2026)</h2>

## 1. Implement Queue using Stacks (LeetCode #232)

### Solution

```c
#define MAX 100

typedef struct {
    int stack1[MAX];
    int stack2[MAX];
    int top1;
    int top2;
} MyQueue;

// Create and initialize the queue
MyQueue* myQueueCreate() {
    MyQueue* obj = (MyQueue*)malloc(sizeof(MyQueue));
    obj->top1 = -1;
    obj->top2 = -1;
    return obj;
}

// Push element into stack1
void myQueuePush(MyQueue* obj, int x) {
    obj->stack1[++obj->top1] = x;
}

// Remove and return the front element
int myQueuePop(MyQueue* obj) {
    // If stack2 is empty, move all elements from stack1 to stack2
    if (obj->top2 == -1) {
        while (obj->top1 != -1) {
            obj->stack2[++obj->top2] = obj->stack1[obj->top1--];
        }
    }
    // Pop from stack2 (front of queue)
    return obj->stack2[obj->top2--];
}

// Return the front element without removing it
int myQueuePeek(MyQueue* obj) {
    // Transfer elements only if stack2 is empty
    if (obj->top2 == -1) {
        while (obj->top1 != -1) {
            obj->stack2[++obj->top2] = obj->stack1[obj->top1--];
        }
    }
    // Top of stack2 is the front of the queue
    return obj->stack2[obj->top2];
}

// Check whether the queue is empty
bool myQueueEmpty(MyQueue* obj) {
    return (obj->top1 == -1 && obj->top2 == -1);
}

// Free allocated memory
void myQueueFree(MyQueue* obj) {
    free(obj);
}

/**
 * Your MyQueue struct will be instantiated and called as such:
 * MyQueue* obj = myQueueCreate();
 * myQueuePush(obj, x);
 *
 * int param_2 = myQueuePop(obj);
 *
 * int param_3 = myQueuePeek(obj);
 *
 * bool param_4 = myQueueEmpty(obj);
 *
 * myQueueFree(obj);
 */
```

---

## 2. Maximum People Visible in a Line

### Solution

```c
#include <stdio.h>
#define MAX 100

int main() {
    int arr[MAX], n;
    int stack[MAX], top = -1;
    int left[MAX], right[MAX];

    printf("Enter number of people: ");
    scanf("%d", &n);

    printf("Enter heights:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    // Find nearest greater or equal element on the left
    top = -1;
    for (int i = 0; i < n; i++) {
        // Remove all smaller heights
        while (top != -1 && arr[stack[top]] < arr[i])
            top--;
        // Store index of nearest greater/equal element
        if (top == -1)
            left[i] = -1;
        else
            left[i] = stack[top];
        // Push current index
        stack[++top] = i;
    }

    // Find nearest greater or equal element on the right
    top = -1;
    for (int i = n - 1; i >= 0; i--) {
        // Remove all smaller heights
        while (top != -1 && arr[stack[top]] < arr[i])
            top--;
        // Store index of nearest greater/equal element
        if (top == -1)
            right[i] = n;
        else
            right[i] = stack[top];
        // Push current index
        stack[++top] = i;
    }

    int maxVisible = 0;
    // Calculate visible people for every person
    for (int i = 0; i < n; i++) {
        // People visible on the left
        int leftCount = i - left[i] - 1;
        // People visible on the right
        int rightCount = right[i] - i - 1;
        // Include the person themselves
        int total = leftCount + rightCount + 1;
        if (total > maxVisible)
            maxVisible = total;
    }

    printf("Maximum people visible = %d\n", maxVisible);
    return 0;
}
```
