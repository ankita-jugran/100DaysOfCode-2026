#include <stdio.h>

#define MAX 100

int main()
{
    int n = 4;
    int k = 3;

    int queue[MAX];
    int front = 0;
    int rear = 0;

    for(int i = 1; i <= n; i++)
    {
        queue[rear++] = i;
    }

    int minute = 0;

    while(front < rear)
    {
        int served = queue[front++];
        minute++;

        if(served == k)
        {
            printf("%d", minute);
            return 0;
        }

        if(front < rear && queue[front] % 2 != 0)
        {
            int person = queue[front++];
            queue[rear++] = person;
        }
    }

    return 0;
}