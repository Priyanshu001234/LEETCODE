import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // Step 1: Sort indices based on positions
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);

        Stack<Integer> stack = new Stack<>();

        // Step 2: Traverse robots
        for (int idx : indices) {
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                // Current robot moving left
                while (!stack.isEmpty() && healths[idx] > 0) {
                    int top = stack.peek();

                    if (healths[top] < healths[idx]) {
                        // R robot dies
                        stack.pop();
                        healths[idx] -= 1;
                        healths[top] = 0;
                    } else if (healths[top] > healths[idx]) {
                        // L robot dies
                        healths[top] -= 1;
                        healths[idx] = 0;
                        break;
                    } else {
                        // Both die
                        stack.pop();
                        healths[top] = 0;
                        healths[idx] = 0;
                        break;
                    }
                }
            }
        }

        // Step 3: Collect survivors
        List<Integer> result = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) result.add(h);
        }

        return result;
    }
}