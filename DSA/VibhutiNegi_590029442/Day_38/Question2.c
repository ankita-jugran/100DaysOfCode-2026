#include <stdio.h>
int main() {
    int n;
    printf("Enter number of cards: ");
    scanf("%d", &n);
    int deque[2000];
    int front = 1000, rear = 999;
    for (int card = n; card >= 1; card--) {
        if (front <= rear) {
            deque[--front] = deque[rear];
            rear--;
        }
        deque[--front] = card;
    }
    printf("Initial arrangement: [");
    for (int i = front; i <= rear; i++) {
        printf("%d", deque[i]);
        if (i != rear)
            printf(", ");
    }
    printf("]\n");
    return 0;
}