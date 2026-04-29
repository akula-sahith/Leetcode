class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] visited, int src, int dest) {
        if (src == dest) return true;

        visited[src] = true;

        for (int nei : graph.get(src)) {
            if (!visited[nei] && dfs(graph, visited, nei, dest)) {
                return true;
            }
        }
        return false;
    }
}