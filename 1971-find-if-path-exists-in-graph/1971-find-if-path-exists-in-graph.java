class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source== destination){
            return true;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }

        for(int i=0;i<edges.length;i++){
            int edgeFrom = edges[i][0];
            int edgeTo = edges[i][1];
            adj.get(edgeFrom).add(edgeTo);
            adj.get(edgeTo).add(edgeFrom);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        queue.offer(source);
        visited[source] =1;
        while(!queue.isEmpty()){
            int curr= queue.remove();
            ArrayList<Integer> temp = adj.get(curr);
            for(int i:temp){
                if(visited[i]== 0){
                    visited[i]=1;
                    if(i== destination) return true;
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}