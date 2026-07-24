class Solution {
public:
    void dfs(int r, int c, vector<vector<int>>& image, int original, int newColor) {
        int n = image.size();
        int m = image[0].size();

        if (r < 0 || r >= n || c < 0 || c >= m)
            return;

        if (image[r][c] != original)
            return;

        image[r][c] = newColor;

        dfs(r - 1, c, image, original, newColor);
        dfs(r + 1, c, image, original, newColor);
        dfs(r, c - 1, image, original, newColor);
        dfs(r, c + 1, image, original, newColor);
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if (original == color)
            return image;

        dfs(sr, sc, image, original, color);

        return image;
    }
};