#include <stdio.h>
int maxPeopleVisible(int arr[], int n) {
    int left[n];   
    int right[n];
    int stack[n];  
    int top = -1;
    for (int i = 0; i < n; i++) {
        while (top != -1 && arr[stack[top]] < arr[i]) {
            top--;
        }
        if (top == -1) {
            left[i] = -1;
        } else {
            left[i] = stack[top];
        }
        top++;
        stack[top] = i;
    }
    top = -1;
    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && arr[stack[top]] < arr[i]) {
            top--;
        }
        if (top == -1) {
            right[i] = n;
        } else {
            right[i] = stack[top];
        }
        top++;
        stack[top] = i;
    }
    int maxCount = 0;
    for (int i = 0; i < n; i++) {
        int count = right[i] - left[i] - 1;
        if (count > maxCount) {
            maxCount = count;
        }
    }
    return maxCount;
}
int main() {
    int arr[] = {6, 2, 5, 4, 5, 1, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("Maximum people visible: %d\n", maxPeopleVisible(arr, n));
    return 0;
}