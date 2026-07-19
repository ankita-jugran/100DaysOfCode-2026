#include <stdio.h>

int maxVisiblePeople(int arr[], int n) {
    int maxVisible = 0;

    for (int i = 0; i < n; i++) {
        int count = 1; // Counting themselves

        // Check left side
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] < arr[i])
                count++;
            else
                break;
        }

        // Check right side
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[i])
                count++;
            else
                break;
        }

        if (count > maxVisible)
            maxVisible = count;
    }

    return maxVisible;
}

int main() {
    int n;

    printf("Enter number of people: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter heights of people:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int result = maxVisiblePeople(arr, n);

    printf("Maximum people visible: %d\n", result);

    return 0;
}