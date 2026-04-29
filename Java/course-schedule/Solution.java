//There are two approaches to solve this problem
//The main point is to find the cycle
//Cycle can be found using DFS with pathVisited and Khans Algorithm
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
         //Build the adjacency List
         List<List<Integer>> adj = new ArrayList<>();
         int V = numCourses;
         for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
         }

         for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
         }

         List<Integer> list = bfstopo(V,adj);

         return list.size()==V;

    }

    //Using khans algorithm
    public List<Integer> bfstopo(int V,List<List<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[V];
        Arrays.fill(indegree,0);
        for(int i = 0 ; i < V ; i++){
            for(int nei : graph.get(i)){
                indegree[nei]++;
            }
        }

        //Push all the zero indegree into the queue
        for(int i = 0 ; i < V ; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int polled = q.poll();
             topo.add(polled);
             for(int nei : graph.get(polled)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }

        return topo;
    }
}