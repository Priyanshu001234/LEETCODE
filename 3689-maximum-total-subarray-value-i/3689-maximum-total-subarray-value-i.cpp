class Solution {
public:
    long long maxTotalValue(vector<int>& nums, int k) {


        int n = nums.size();
        long long mini = nums[0];
        long long maxi = nums[0];

        for(int i=1;i<n;i++){
           maxi = max(maxi,(long long)nums[i]);
           mini = min(mini,(long long)nums[i]);
        }

        long long ans = (maxi-mini) * k;

        return ans;

        
    }
};