/* Q1: Given an array representing the heights of people standing in a line, 
find the maximum number of people visible to any single person 
(including themselves).

Example:
Input: arr[] = [6, 2, 5, 4, 5, 1, 6];  Output: 6  */


#include <stdio.h>

int main()
{
    int i, j, n, count, max_count = 0;

    printf("Enter the number of people: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter the heights of people: ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    for (i=0; i<n; i++)
    {
        count =1;

        for (j=i+1; j<n; j++)
        {
            if (arr[j] >= arr[i])
            {
                break;
            }
            count++;
        }

        for (j=i-1; j>=0; j--)
        {
            if (arr[j] >= arr[i])
            {
                break;
            }
            count++;
        }
        if (count > max_count)
        {
            max_count = count;
        }
    }

    printf("%d", max_count);
    return 0;
}