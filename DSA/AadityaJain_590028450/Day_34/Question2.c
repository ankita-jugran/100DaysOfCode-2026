/*Maximum People Visible in a Line
Explanation
Given an array representing the heights of people standing in a line, find the maximum number of people visible to any single person (including themselves).*/

#include<stdio.h>
#define MAX 100

int maxVisiblePeople(int arr[], int n){
    int left[MAX] = {0}, right[MAX] = {0};
    int stack[MAX];
    int top = -1;

    for(int i = 0; i < n; i++){
        while(top != -1 && arr[stack[top]] < arr[i]){
            left[i]++;
            top--;
        }

        if(top != -1){
            left[i]++;
        }

        stack[++top] = i;
    }

    top = -1;

    for(int i = n - 1; i >= 0; i--){
        while(top != -1 && arr[stack[top]] < arr[i]){
            right[i]++;
            top--;
        }

        if(top != -1){
            right[i]++;
        }
        stack[++top] = i;
    }

    int maxVisible = 0;
    for(int i = 0; i < n; i++){
        int total = left[i] + right[i] + 1; 
        if(total > maxVisible){
            maxVisible = total;
        }
    }

    return maxVisible;
}

int main(){

    int n, arr[MAX];

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    printf("Enter the heights: ");
    for(int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }

    printf("%d\n", maxVisiblePeople(arr, n));

    return 0;
}