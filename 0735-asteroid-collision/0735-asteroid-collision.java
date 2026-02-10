class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];

            if (current > 0) {
                stack.push(current);
            } else {
                boolean exploded = false;

                while (!stack.isEmpty() && stack.peek() > 0) {
                    int lastInStack = stack.peek();

                    if (Math.abs(current) > lastInStack) {
                        stack.pop();              // stack asteroid explodes
                        continue;
                    } else if (Math.abs(current) == lastInStack) {
                        stack.pop();              // both explode
                        exploded = true;
                        break;
                    } else {
                        exploded = true;          // current explodes
                        break;
                    }
                }

                if (!exploded) {
                    stack.push(current);
                }
            }
        }

        // convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
