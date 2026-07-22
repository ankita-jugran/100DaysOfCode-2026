#include <stdio.h>
#include <stdlib.h>

#define MAX 1000

void cardTrick(int n)
{
    int result[MAX];
    int queue[MAX];
    int front = 0, rear = 0;

    // Queue of positions
    for (int i = 0; i < n; i++)
        queue[rear++] = i;

    // Place cards 1 to n
    for (int card = 1; card <= n; card++)
    {
        int pos = queue[front++];
        result[pos] = card;

        if (front < rear)
        {
            queue[rear++] = queue[front++];
        }
    }

    printf("[");
    for (int i = 0; i < n; i++)
    {
        printf("%d", result[i]);
        if (i != n - 1)
            printf(", ");
    }
    printf("]\n");
}

int main()
{
    int n = 4;

    cardTrick(n);

    return 0;
}