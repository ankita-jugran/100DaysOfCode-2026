// Problem 2 
// Maximum People Visible in a Line 

#include <stdio.h>

int main() {
    int n;
    printf("Enter number of people: ");
    scanf("%d", &n);

    int height[n];

    printf("Enter heights: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &height[i]);
    }

    int stack[n];
    int left[n];
    int right[n];
    int top = -1;

    for (int i = 0; i < n; i++) {
        while (top != -1 && height[stack[top]] < height[i]) {
            top--;
        }

        if (top == -1)
            left[i] = i;
        else
            left[i] = i - stack[top] - 1;

        top++;
        stack[top] = i;
    }

    top = -1;
    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && height[stack[top]] < height[i]) {
            top--;
        }

        if (top == -1)
            right[i] = n - i - 1;
        else
            right[i] = stack[top] - i - 1;

        top++;
        stack[top] = i;
    }

    int maximumVisible = 1;

    for (int i = 0; i < n; i++) {
        int totalVisible = left[i] + right[i] + 1;
        if (totalVisible > maximumVisible)
            maximumVisible = totalVisible;
    }

    printf("Maximum people visible = %d ", maximumVisible);

    return 0;
}