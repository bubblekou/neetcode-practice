class Solution {
    private class FindUnion {
        private int[] parent;
        private int[] rank;

        public FindUnion(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find (int u) {
            while (u != parent[u]) {
                u = parent[u];
            }

            return u;
        }

        public boolean union(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);
            if (p1 == p2) {
                return false;
            }

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }

            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                   Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {i, j, dist});
            }
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        int cost = 0;
        int used = 0;
        FindUnion fu = new FindUnion(n);
        for (int[] e : edges) {
            int p1 = e[0];
            int p2 = e[1];
            if (fu.union(p1, p2)) {
                used++;
                cost += e[2];
            }

            if (used == n - 1) break;
        }

        return cost;
    }
}
