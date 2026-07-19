#include <stdio.h>

int maxVisiblePeople(int arr[], int n)
{
    int left[n], right[n];
    int stack[n];
    int top = -1;

    // left
    for (int i = 0; i < n; i++)
    {
        while (top >= 0 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            left[i] = i;
        else
            left[i] = i - stack[top];

        stack[++top] = i;
    }

    
    top = -1;

    // right
    for (int i = n - 1; i >= 0; i--)
    {
        while (top >= 0 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            right[i] = n - 1 - i;
        else
            right[i] = stack[top] - i;

        stack[++top] = i;
    }

    int ans = 1;

    for (int i = 0; i < n; i++)
    {
        int visible = left[i] + right[i] + 1;
        if (visible > ans)
            ans = visible;
    }

    return ans;
}

int main()
{
    int arr[] = {6, 2, 5, 4, 5, 1, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d\n", maxVisiblePeople(arr, n));

    return 0;
}