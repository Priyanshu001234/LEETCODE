class Solution {
    private:

    bool canEat(vector<int> &piles,int mid,int h){

        int n = piles.size();
        long long total = 0;
        for(int i=0;i<n;i++){
            total += ceil((double)piles[i] / mid);
            
        }

        return total <= h;

    }

public:
    int minEatingSpeed(vector<int>& piles, int h) {

        int n = piles.size();
        int low = 1, high = *max_element(piles.begin(),piles.end());
        int ans = 0;

        while(low <= high){

            int mid = low + (high-low) / 2;

            if(canEat(piles,mid,h)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }

        }

        return ans;
        
    }
};