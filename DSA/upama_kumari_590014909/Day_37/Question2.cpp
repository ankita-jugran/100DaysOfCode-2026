#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int printerQueue(vector<int>&priorities,int location){
    queue<pair<int,int>>q;

    for(int i = 0;i<priorities.size();i++){
        q.push({priorities[i],i});
    }

    int time = 0;

    while(!q.empty()){
        pair<int,int>curr = q.front();
        q.pop();

        bool higher = false;
        int sz = q.size();

        for(int i = 0 ;i<sz;i++){
            pair<int,int>temp = q.front();
            q.pop();

            if(temp.first > curr.first)
               higher = true;

            q.push(temp);
        }
        if(higher){
            q.push(curr);
        }else{
            time++;
            if(curr.second == location){
                return time;
            }
        }
    }
    return time;
};
int main(){
    vector<int>priorities = {2,1,3,2};
    int location = 2;

    cout<<printerQueue(priorities,location);

    return 0 ;
}