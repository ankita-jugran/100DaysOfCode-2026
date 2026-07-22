typedef struct{
    int ans[10000],f,r;
}RecentCounter;
RecentCounter* recentCounterCreate(){
    RecentCounter* obj=(RecentCounter*)malloc(sizeof(RecentCounter));
    obj->f=0;
    obj->r=-1;
    return obj;
}

int recentCounterPing(RecentCounter* obj,int t){
    obj->ans[++obj->r]=t;
    while(obj->ans[obj->f]<t-3000) obj->f++;
    return obj->r-obj->f+1;
}

void recentCounterFree(RecentCounter* obj){
    free(obj);
}

/**
 * Your RecentCounter struct will be instantiated and called as such:
 * RecentCounter* obj = recentCounterCreate();
 * int param_1 = recentCounterPing(obj,t);
 * recentCounterFree(obj);
 */
