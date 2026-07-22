#include <stdio.h>
int countStudents(int students[], int sandwiches[], int n) {
    int queue[100];
    int front = 0, rear = n - 1;

    // Copy students into queue
    for (int i = 0; i < n; i++)
        queue[i] = students[i];

    int sandwichIndex = 0;
    int count = n;
    int rotations = 0;

    while (count > 0 && rotations < count) {
        // Student takes sandwich
        if (queue[front] == sandwiches[sandwichIndex]) {
            front++;
            sandwichIndex++;
            count--;
            rotations = 0;
        }
        // Move student to the back
        else {
            queue[++rear] = queue[front++];
            rotations++;
        }
    }

    return count;
}

int main() {
    int n;

    printf("Enter number of students: ");
    scanf("%d", &n);

    int students[100], sandwiches[100];

    printf("Enter students preferences (0/1):\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &students[i]);

    printf("Enter sandwiches (0/1):\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &sandwiches[i]);

    printf("Students unable to eat: %d\n",
           countStudents(students, sandwiches, n));
    return 0;
}