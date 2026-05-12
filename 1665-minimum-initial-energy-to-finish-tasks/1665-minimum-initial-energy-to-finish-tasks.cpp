class Solution {
    private:

    bool isPossible(vector<vector<int>> &tasks,int mid){

        int n = tasks.size();

        for(int i=n-1;i>=0;i--){
            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            if(mid < minimum ) return false;

            mid -= actual;

        }

        return mid >= 0;

    }

public:
    int minimumEffort(vector<vector<int>>& tasks) {
     
    int n = tasks.size();
    int low = 0;
    int high = 0;
    int ans = -1;

      for(int i=0;i<n;i++){
        low += tasks[i][0];
        high += tasks[i][1];
     }

        sort(tasks.begin(),tasks.end(), [] (vector <int> &a, vector<int> &b) {
            return a[1] - a[0] < b[1] - b[0];
        } );

      while(low <= high){

        int mid = low + (high-low) / 2;

       if(isPossible(tasks,mid)){
            ans = mid;
            high = mid-1;
       }

       else low = mid + 1;
        

      } 
        return ans;
    
    }
};