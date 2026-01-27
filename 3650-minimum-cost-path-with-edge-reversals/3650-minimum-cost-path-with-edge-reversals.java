import java.util.*;

class Solution {
    static class Edge {
        int to, cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new Edge(v, w));        // normal
            graph[v].add(new Edge(u, 2 * w));    // reversed
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[1])
        );
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];

            if (cost > dist[node]) continue;

            for (Edge e : graph[node]) {
                int next = e.to;
                int newCost = cost + e.cost;
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new int[]{next, newCost});
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
