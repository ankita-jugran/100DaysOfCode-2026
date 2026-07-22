#include <stdio.h>

#define MAX 2005

int main() {

    int n;
    printf("Enter number of cards: ");
    scanf("%d", &n);

    int deque[MAX];
    int front = MAX / 2;
    int rear = MAX / 2 - 1;

    for (int card = n; card >= 1; card--) {

        if (front <= rear) {
            int last = deque[rear--];
            deque[--front] = last;
        }

        deque[--front] = card;
    }

    printf("Initial arrangement: ");

    for (int i = front; i <= rear; i++) {
        printf("%d ", deque[i]);
    }

    printf("\n");

    return 0;
}