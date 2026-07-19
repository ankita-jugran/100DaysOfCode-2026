#include <stdio.h>

#define MAX 1000

int maxVisiblePeople(int arr[], int n) {

    int prev[MAX], next[MAX];
    int stack[MAX], top = -1;

    // Previous Greater or Equal
    for (int i = 0; i < n; i++) {
        while (top != -1 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            prev[i] = -1;
        else
            prev[i] = stack[top];

        stack[++top] = i;
    }

    // Next Greater or Equal
    top = -1;
    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && arr[stack[top]] < arr[i])
            top--;

        if (top == -1)
            next[i] = n;
        else
            next[i] = stack[top];

        stack[++top] = i;
    }

    int ans = 1;

    for (int i = 0; i < n; i++) {
        int left = i - prev[i] - 1;
        int right = next[i] - i - 1;
        int total = left + right + 1;

        if (total > ans)
            ans = total;
    }

    return ans;
}

int main() {

    int n;

    printf("Enter number of people: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter heights: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Maximum people visible: %d\n", maxVisiblePeople(arr, n));

    return 0;
}