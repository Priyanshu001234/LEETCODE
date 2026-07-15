class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> st;

        for (int i : asteroids) {
            bool alive = true;

            while (alive && !st.empty() && st.top() > 0 && i < 0) {

                if (st.top() < abs(i)) {
                    st.pop();
                }
                else if (st.top() == abs(i)) {
                    st.pop();
                    alive = false;
                }
                else {
                    alive = false;
                }
            }

            if (alive)
                st.push(i);
        }

        vector<int> ans(st.size());

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.top();
            st.pop();
        }

        return ans;
    }
};