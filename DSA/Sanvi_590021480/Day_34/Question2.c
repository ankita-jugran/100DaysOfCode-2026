#include <stdio.h>

int main() {
    
    int n,max=1;
    
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter array elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    for(int i=0;i<n;i++){
        int count=1;
        for(int j=i-1;j>=0;j--){
            if(arr[j]>=arr[i]) break;
            count++;
        }
        for(int j=i+1;j<n;j++){
            if(arr[j]>=arr[i]) break;
            count++;
        }
        if(count>max)
        max=count;
    }
    printf("%d",max);
    return 0;
}
