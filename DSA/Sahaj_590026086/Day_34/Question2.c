#include <stdio.h>

int main() {
    int n;
    printf("Enter the number of elements:");
    scanf("%d", &n);
    int h[n];
    for (int i=0;i<n;i++)
        printf("Enter the element:");
        scanf("%d", &h[i]);

    int visible=0;

    for (int i=0;i<n;i++){
        int count=1;
        int left=h[i];
        for (int j=i-1;j>=0;j--){
            if (h[j]>=left){
                count++;
                left=h[j];
            }
        }
        int right=h[i];
        for (int j=i+1;j<n;j++){
            if (h[j]>=right){
                count++;
                right=h[j];
            }
        }
        if (count>visible)
            visible=count;
    }

    printf("%d\n", visible);
    return 0;
}
