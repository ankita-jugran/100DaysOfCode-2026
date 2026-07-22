#include <stdio.h>

int countStudents(int students[], int n, int sandwiches[]) {
    int count[2] = {0, 0};

    for (int i = 0; i < n; i++) {
        count[students[i]]++;
    }

    for (int i = 0; i < n; i++) {
        int type = sandwiches[i];

        if (count[type] == 0)
            break;

        count[type]--;
    }

    return count[0] + count[1];
}

int main() {
    int n;

    printf("Enter number of students: ");
    scanf("%d", &n);

    int students[n];
    int sandwiches[n];

    printf("Enter student preferences (0 = circular, 1 = square):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &students[i]);
    }

    printf("Enter sandwiches (0 = circular, 1 = square):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &sandwiches[i]);
    }

    int result = countStudents(students, n, sandwiches);

    printf("Students unable to eat: %d\n", result);

    return 0;
}