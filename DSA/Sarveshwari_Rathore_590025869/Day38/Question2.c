#include <stdio.h>
#include <stdlib.h>

int* deckRevealedIncreasing(int n, int* returnSize){
    *returnSize = n;
    int* ans = (int*)malloc(n * sizeof(int));
    int* q = (int*)malloc(n * sizeof(int));
    int bottom = 0, top = n - 1;
    for(int i = 0; i < n; i++){
        q[i] = i;

    }
    for(int card = 1; card <= n; card++) {
        int idx = q[bottom++];
        ans[idx] = card;
        if(bottom <= top){
            q[++top] = q[bottom++];
        }
    }
    free(q);
    return ans;
}
int main(){
    int n, returnSize;
    printf("Enter number of cards: ");
    scanf("%d", &n);
    int *result = deckRevealedIncreasing(n, &returnSize);
    printf("Initial deck arrangement:");
    for(int i = 0; i < returnSize; i++){
        printf("%d ", result[i]);
    }
    printf("\n");
    free(result);
    return 0;
}