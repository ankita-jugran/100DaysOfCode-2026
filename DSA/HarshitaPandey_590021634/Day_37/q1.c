/* Q1: Simulate a priority-based printer queue to determine how many minutes it takes 
for a document at a given position to be printed.

Example:
Input: priorities = [2, 1, 3, 2], location = 2;  Output: 1.   */



#include <stdio.h>

int printerQueue (int priorities[], int size, int location)
{
    int queue[100];      
    int n = size;
    int front = 0, rear = 0;

    
    for (int i = 0; i < n; i++)
    {
        queue[rear] = i;
        rear++;
    }

    int minutes = 0;

    while (front < rear)
    {
        int currentIdx = queue[front];   
        int highest = 1;
        
        
        for (int i = front; i < rear; i++)
        {
            if (priorities[queue[i]] > priorities[currentIdx])
            {
                highest = 0;
                break;
            }
        }

        if (highest)
        {
            front++;              
            minutes++;

            if (currentIdx == location)
            {
                return minutes;    
            }
        }
        else
        {
            front++;             
            queue[rear] = currentIdx;
            rear++;               
        }
    }

    return -1;  
}


int main()
{
    int priorities[] = {2, 1, 3, 2};
    int size = 4;
    int location = 2;

    printf("%d\n", printerQueue(priorities, size, location));  

    return 0;
}
