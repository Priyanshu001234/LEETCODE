class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int current = heights[i];
            while (!stack.isEmpty() && current <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) prevSmaller[i] = -1;
            else prevSmaller[i] = stack.peek();
            stack.push(i);
        }

        Stack<Integer> stack2 = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = heights[i];
            while (!stack2.isEmpty() && current <= heights[stack2.peek()]) {
                stack2.pop();
            }
            if (stack2.isEmpty()) nextSmaller[i] = n;
            else nextSmaller[i] = stack2.peek();
            stack2.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (nextSmaller[i] - prevSmaller[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
