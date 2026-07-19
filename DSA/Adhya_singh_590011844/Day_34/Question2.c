#include <stdio.h>
#include <stdlib.h>

int maxPeopleSeen(int arr[], int n) {
    int *left = (int *)malloc(n * sizeof(int));
    int *right = (int *)malloc(n * sizeof(int));
    int stack[n], top = -1;

    for (int i = 0; i < n; i++) {
        while (top != -1 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            left[i] = i;
        else
            left[i] = i - stack[top] - 1;

        stack[++top] = i;
    }

    top = -1;
    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            right[i] = n - i - 1;
        else
            right[i] = stack[top] - i - 1;

        stack[++top] = i;
    }

    int ans = 1;
    for (int i = 0; i < n; i++) {
        int total = left[i] + right[i] + 1;
        if (total > ans)
            ans = total;
    }

    free(left);
    free(right);

    return ans;
}

int main() {
    int n;

    printf("Enter number of people: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter heights:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Maximum people visible: %d\n", maxPeopleSeen(arr, n));

    return 0;
}