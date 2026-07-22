#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

void deckRevealedIncreasing(int n, int result[]) {
    int queue[MAX_SIZE];

    int front = 0;
    int rear = 0;

    for (int i = 0; i < n; i++) {
        queue[rear++] = i;
    }

    for (int card = 1; card <= n; card++) {

        int position = queue[front++];

        result[position] = card;

        if (front < rear) {
            queue[rear++] = queue[front++];
        }
    }
}

int main() {
    int n;
    int result[MAX_SIZE];

    printf("Enter number of cards: ");
    scanf("%d", &n);

    deckRevealedIncreasing(n, result);

    printf("Initial deck arrangement: ");

    for (int i = 0; i < n; i++) {
        printf("%d ", result[i]);
    }

    printf("\n");

    return 0;
}
