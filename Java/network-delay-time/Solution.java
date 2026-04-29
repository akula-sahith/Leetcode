import java.util.*;

class Solution {
    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph
        for (int[] t : times) {
            graph.get(t[0] - 1).add(new Pair(t[1] - 1, t[2]));
        }

        return dijkstra(graph, n, k - 1);
    }

    public int dijkstra(List<List<Pair>> graph, int n, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.dist > dist[curr.node]) continue; 

            for (Pair nei : graph.get(curr.node)) {
                int newDist = curr.dist + nei.dist;

                if (newDist < dist[nei.node]) {
                    dist[nei.node] = newDist;
                    pq.add(new Pair(nei.node, newDist));
                }
            }
        }

        int max = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1;
            max = Math.max(max, d);
        }

        return max;
    }
}