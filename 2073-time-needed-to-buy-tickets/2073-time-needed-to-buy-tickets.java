class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new int[]{i, tickets[i]});
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            person[1]--;
            time++;

            if (person[0] == k && person[1] == 0) {
                return time;
            }

            if (person[1] > 0) {
                queue.offer(person);
            }
        }

        return time;
    }
}
