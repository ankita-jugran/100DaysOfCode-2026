class Solution {
  public:
    int maxPeople(vector<int> &arr) {
        int n = arr.size();
        stack<int> st;
        vector<int> l(n);
        
        for(int i = 0;i<n;i++){
            while(!st.empty() and arr[st.top()]<arr[i]){
                st.pop();
            }    
            if(st.empty()){
                l[i] = i;
            }
            else{
                l[i] = i-st.top()-1;
            }
            st.push(i);
        }
        while(!st.empty())st.pop();
        
        vector<int> r(n);
        for(int i = n-1;i>=0;i--){
            while(!st.empty() and arr[st.top()]<arr[i]){
                st.pop();
            }    
            if(st.empty()){
                r[i] = n - i - 1;
            }
            else{
                r[i] = st.top() - i - 1;
            }
            st.push(i);
        }
        
        int maxi = 0;
        for(int i = 0;i<n;i++){
            maxi = max(maxi, l[i]+r[i]+1);
        }
        
        return maxi;
    }
};