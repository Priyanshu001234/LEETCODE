import java.util.*;

class Solution {
    private Integer[][] f;
    private int[][] arr;
    private int[] walls;
    private int n;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        n = robots.length;
        arr = new int[n][2];

        // Store each robot with its distance
        for (int i = 0; i < n; i++) {
            arr[i][0] = robots[i];   // position
            arr[i][1] = distance[i]; // range
        }

        // Sort robots by position
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // Sort walls
        Arrays.sort(walls);
        this.walls = walls;

        // Memoization table: f[i][j]
        // i = robot index, j = firing direction of the NEXT robot (0=left, 1=right)
        f = new Integer[n][2];

        return dfs(n - 1, 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) return 0;
        if (f[i][j] != null) return f[i][j];

        // ---- Option 1: Robot i fires LEFT ----
        int left = arr[i][0] - arr[i][1];
        // Blocked by left neighbor robot
        if (i > 0) left = Math.max(left, arr[i - 1][0] + 1);
        int l = lowerBound(walls, left);
        int r = lowerBound(walls, arr[i][0] + 1); // walls at robot pos included
        int ans = dfs(i - 1, 0) + (r - l);

        // ---- Option 2: Robot i fires RIGHT ----
        int right = arr[i][0] + arr[i][1];
        // Blocked by right neighbor robot
        if (i + 1 < n) {
            if (j == 0) {
                // Next robot fires left: its bullet starts from arr[i+1][0] - arr[i+1][1]
                // so current bullet can only go up to that start - 1
                right = Math.min(right, arr[i + 1][0] - arr[i + 1][1] - 1);
            } else {
                // Next robot fires right: blocked physically by robot body
                right = Math.min(right, arr[i + 1][0] - 1);
            }
        }
        l = lowerBound(walls, arr[i][0]);
        r = lowerBound(walls, right + 1);
        ans = Math.max(ans, dfs(i - 1, 1) + (r - l));

        return f[i][j] = ans;
    }

    // Standard lower_bound: first index where walls[index] >= target
    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}