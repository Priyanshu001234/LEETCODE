class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        int n = words.size();
        int m = weights.size();

    

        int cnt = 0;
        string ans = "";

        for(int x=0;x<n;x++){
            int sum = 0;
            for(int j=0;j<words[x].length();j++){
                char ch = words[x][j];
                sum += weights[ch - 'a'];
            }
            sum = sum%26;
            ans += char('z' - sum);
        }
        return ans;
    }
};