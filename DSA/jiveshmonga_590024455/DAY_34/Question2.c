#include <stdio.h>
int maxVisible(int arr[],int n) {
    int maxCount=1;
    for (int i=0;i<n;i++) {
        int visible=1; 
        for (int j=0;j<n;j++) {
            if (i==j)
                continue;
            int limit=(arr[i]<arr[j])?arr[i]:arr[j];
            int canSee=1;
            for (int k = (i<j?i+1:j+1);
                 k < (i<j?j:i);
                 k++) 
                 {
                if (arr[k]>limit) 
                {
                    canSee=0;
                    break;
                }
            }
            if (canSee)
                visible++;
        }
        if (visible>maxCount)
            maxCount=visible;
    }
    return maxCount;
}
int main() 
{
    int arr[] = {6,2,5,4,5,1,6};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("%d\n",maxVisible(arr,n));
    return 0;
}