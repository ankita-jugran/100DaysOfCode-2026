#include <stdio.h>

int countStudentsUnableToEat(int students[], int sandwiches[], int n) {

    int count0 = 0, count1 = 0;

    for (int i = 0; i < n; i++) {
        if (students[i] == 0)
            count0++;
        else
            count1++;
    }

    for (int i = 0; i < n; i++) {

        if (sandwiches[i] == 0) {
            if (count0 == 0)
                break;
            count0--;
        }
        else {
            if (count1 == 0)
                break;
            count1--;
        }
    }

    return count0 + count1;
}

int main() {

    int n;

    printf("Enter number of students: ");
    scanf("%d", &n);

    int students[n], sandwiches[n];

    printf("Enter students preferences (0/1): ");
    for (int i = 0; i < n; i++)
        scanf("%d", &students[i]);

    printf("Enter sandwiches stack (top to bottom): ");
    for (int i = 0; i < n; i++)
        scanf("%d", &sandwiches[i]);

    printf("Students unable to eat: %d\n",
           countStudentsUnableToEat(students, sandwiches, n));

    return 0;
}