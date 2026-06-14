class Solution {
    private class FindUnion {
        private int[] parents;
        private int[] sizes;

        public FindUnion(int n) {
            this.parents = new int[n];
            this.sizes = new int[n];

            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
                this.sizes[i] = 1;
            }
        }

        public int find(int p) {
            if (parents[p] != p) {
                parents[p] = find(parents[p]);
            }

            return parents[p];
        }

        public void union(int p, int q) {
            int parentP = find(p);
            int parentQ = find(q);
            if (parentP == parentQ) {
                return;
            }

            if (sizes[p] < sizes[q]) {
                parents[p] = parentQ;
            } else {
                parents[q] = parentP;
            }
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
