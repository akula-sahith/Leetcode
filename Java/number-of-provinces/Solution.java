class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                bfs(isConnected,visited,i);
                provinces++;
            }
        }
        
        return provinces;
    }

    public void dfs(int[][] graph,boolean[] visited,int city){
        visited[city] = true;
        for(int j = 0 ; j < graph.length ; j++){
            if(graph[city][j]==1 && !visited[j]){
                dfs(graph,visited,j);
            }
        }
        return;
    }

    public void bfs(int[][] graph,boolean[] visited,int city){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(city);
        visited[city] = true;
        while(!queue.isEmpty()){
            int polled = queue.poll();

            for(int j = 0 ; j < graph.length ; j++){
                if(graph[polled][j]==1 && !visited[j]){
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
        return;
    }
}