#include <stdio.h>


int main() {
    
    int n;
    printf("Enter n: ");
    scanf("%d",&n);
    int deque[10000];
    int ans[n];
    int front=1000,rear=999;
    for(int i=n;i>=1;i--){
        if(front<=rear){
            int last=deque[rear--];
            deque[--front]=last;
        }
        deque[--front]=i;
    }
    int k=0;
    while(front<=rear){
        ans[k++]=deque[front++];
    }
    for(int i=0;i<n;i++){
        printf("%d ",ans[i]);
    }
    
    return 0;
}
