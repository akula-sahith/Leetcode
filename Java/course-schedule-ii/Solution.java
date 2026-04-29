import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph (b → a)
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> topo = bfsApproach(graph, V);

       
        if (topo.size() != V) return new int[0];

        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            ans[i] = topo.get(i);
        }

        return ans;
    }

    static List<Integer> bfsApproach(List<List<Integer>> graph, int V) {
        int[] indegree = new int[V];

        // calculate indegree
        for (int i = 0; i < V; i++) {
            for (int neighbour : graph.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neighbour : graph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        return topo;
    }
}