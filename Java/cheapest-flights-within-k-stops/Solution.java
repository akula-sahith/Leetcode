import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build adjacency list
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adj.get(u).add(new int[]{v, w});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int[] shortDist = new int[n];
        Arrays.fill(shortDist, Integer.MAX_VALUE);
        shortDist[src] = 0;

        int stops = 0;

        while (stops <= k && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int dist = curr[1];

                for (int[] nei : adj.get(node)) {
                    int neighbour = nei[0];
                    int weight = nei[1];

                    int newDist = dist + weight;

                    if (newDist < shortDist[neighbour]) {
                        shortDist[neighbour] = newDist;
                        queue.offer(new int[]{neighbour, newDist});
                    }
                }
            }

            stops++;
        }

        return shortDist[dst] == Integer.MAX_VALUE ? -1 : shortDist[dst];
    }
}