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

        public int find(int p) {
            while (p != this.parent[p]) {
                p = parent[p];
            }

            return p;
        }

        public void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return;
            }

            if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
                rank[pu] += rank[pv];
            } else {
                parent[pu] = pv;
                rank[pv] += rank[pu];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        FindUnion fu = new FindUnion(n + 1);

        for (int[] e : edges) {
            int p1 = fu.find(e[0]);
            int p2 = fu.find(e[1]);
            if (p1 == p2) {
                return e;
            }

            fu.union(e[0], e[1]);
        }

        return null;
    }
}
