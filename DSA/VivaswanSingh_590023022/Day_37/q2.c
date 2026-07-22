#include <stdio.h>

#define MAX 100

typedef struct
{
    int priority;
    int index;
} Document;

int printerQueue(int priorities[], int n, int location)
{
    Document queue[MAX];
    int front = 0, rear = 0;

    for (int i = 0; i < n; i++)
    {
        queue[rear].priority = priorities[i];
        queue[rear].index = i;
        rear++;
    }

    int minutes = 0;

    while (front < rear)
    {
        Document current = queue[front++];
        int higher = 0;

        for (int i = front; i < rear; i++)
        {
            if (queue[i].priority > current.priority)
            {
                higher = 1;
                break;
            }
        }

        if (higher)
        {
            queue[rear++] = current;
        }
        else
        {
            minutes++;

            if (current.index == location)
                return minutes;
        }
    }

    return -1;
}

int main()
{
    int priorities[] = {2, 1, 3, 2};
    int n = sizeof(priorities) / sizeof(priorities[0]);
    int location = 2;

    printf("%d\n", printerQueue(priorities, n, location));

    return 0;
}