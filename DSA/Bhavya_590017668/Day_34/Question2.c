#include <stdio.h>
#include <stdlib.h>

int maxPeopleVisible(int arr[], int n) {
    int *left = (int *)malloc(n * sizeof(int));
    int *right = (int *)malloc(n * sizeof(int));
    int *stack = (int *)malloc(n * sizeof(int));

    int top = -1;

    // Previous Greater or Equal
    for (int i = 0; i < n; i++) {
        while (top >= 0 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            left[i] = -1;
        else
            left[i] = stack[top];

        stack[++top] = i;
    }

    top = -1;

    // Next Greater or Equal
    for (int i = n - 1; i >= 0; i--) {
        while (top >= 0 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            right[i] = n;
        else
            right[i] = stack[top];

        stack[++top] = i;
    }

    int ans = 1;

    for (int i = 0; i < n; i++) {
        int visible = right[i] - left[i] - 1;
        if (visible > ans)
            ans = visible;
    }

    free(left);
    free(right);
    free(stack);

    return ans;
}

int main() {
    int n;
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("%d\n", maxPeopleVisible(arr, n));

    return 0;
}