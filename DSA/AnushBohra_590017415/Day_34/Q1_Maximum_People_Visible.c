#include <stdio.h>
#include <stdlib.h>

int maxPeopleVisible(int* arr, int arrSize) {
    if (arrSize <= 0) return 0;
    
    int* visibleLeft = (int*)calloc(arrSize, sizeof(int));
    int* visibleRight = (int*)calloc(arrSize, sizeof(int));
    int* stack = (int*)malloc(arrSize * sizeof(int));
    int top = -1;

    for (int i = 0; i < arrSize; i++) {
        while (top >= 0 && arr[stack[top]] <= arr[i]) {
            int poppedIdx = stack[top--];
            visibleRight[poppedIdx]++;
        }
        if (top >= 0) {
            visibleRight[stack[top]]++;
        }
        stack[++top] = i;
    }

    top = -1;

    for (int i = arrSize - 1; i >= 0; i--) {
        while (top >= 0 && arr[stack[top]] <= arr[i]) {
            int poppedIdx = stack[top--];
            visibleLeft[poppedIdx]++;
        }
        if (top >= 0) {
            visibleLeft[stack[top]]++;
        }
        stack[++top] = i;
    }

    int maxVisible = 0;
    for (int i = 0; i < arrSize; i++) {
        int total = visibleLeft[i] + visibleRight[i] + 1;
        if (total > maxVisible) {
            maxVisible = total;
        }
    }

    free(visibleLeft);
    free(visibleRight);
    free(stack);

    return maxVisible;
}

int main() {
    int arr[] = {6, 2, 5, 4, 5, 1, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Input Array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    int result = maxPeopleVisible(arr, n);
    printf("Maximum People Visible: %d\n", result);

    return 0;
}