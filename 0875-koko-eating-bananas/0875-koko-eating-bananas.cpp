class Solution {
public:

    int findMaxElement(vector<int>&piles){
        int maximum = INT_MIN;
        for(int i=0;i<piles.size();i++){
            maximum = max(maximum,piles[i]);
        }
        return maximum;
    }
    long long calculateHours(vector<int>&piles,int k){
        long long totalHours=0;
        for(int i=0;i<piles.size();i++){
            totalHours+=ceil((double)piles[i]/k);
        }
        return totalHours;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int low=1;
        int high=findMaxElement(piles);
        
        while(low<=high){
            int mid=(low +high)/2;
            long long totalHours=calculateHours(piles,mid);
            if(totalHours<=h){
                
                high = mid-1;

            }
            else{
                low = mid+1;
            }
        }
        return low;

        
    }
};