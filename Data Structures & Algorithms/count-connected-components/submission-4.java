class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
        for (int[] e : edges) {
            adjacencyListMap.putIfAbsent(e[0], new ArrayList<>());
            adjacencyListMap.get(e[0]).add(e[1]);

            adjacencyListMap.putIfAbsent(e[1], new ArrayList<>());
            adjacencyListMap.get(e[1]).add(e[0]);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(adjacencyListMap, i, visited);
            }
        }

        return res;
    }

    private void dfs(Map<Integer, List<Integer>> adjancencyListMap, int current, boolean[] visited) {
        visited[current] = true;

        if (!adjancencyListMap.containsKey(current)) {
            return;
        }

        for (int next : adjancencyListMap.get(current)) {
            if (!visited[next]) {
                dfs(adjancencyListMap, next, visited);
            }
        }
    }

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

    public int countComponents_find_union(int n, int[][] edges) {
        int components = n;
        FindUnion fu = new FindUnion(n);
        for (int[] e : edges) {
            int parent1 = fu.find(e[0]);
            int parent2 = fu.find(e[1]);
            if (parent1 != parent2) {
                fu.union(e[0], e[1]);
                components--;
            }
        }

        return components;
    }
}
