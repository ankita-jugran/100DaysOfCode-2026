#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int arr[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int maxVisible = 1;

    for (int i = 0; i < n; i++) {
        int count = 1; // person can always see themselves

        // Look left
        int maxLeft = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] > maxLeft) {
                count++;
                maxLeft = arr[j];
            }
        }

        // Look right
        int maxRight = 0;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] > maxRight) {
                count++;
                maxRight = arr[j];
            }
        }

        if (count > maxVisible)
            maxVisible = count;
    }

    printf("%d", maxVisible);

    return 0;
}
