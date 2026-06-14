class Solution {
    private class FindUnion {
        private int[] parents;

        public FindUnion(int n) {
            this.parents = new int[n];

            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
            }
        }

        public int find(int p) {
            if (this.parents[p] != p) {
                this.parents[p] = find(this.parents[p]);
            }

            return this.parents[p];
        }

        public void union(int p, int q) {
            int parentP = find(p);
            int parentQ = find(q);
            if (parentP == parentQ) {
                return;
            }

            parents[p] = parentQ;
        }
    }

    public int countComponents(int n, int[][] edges) {
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
