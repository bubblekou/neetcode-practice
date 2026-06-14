class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
        for (int[] e : edges) {
            adjacencyListMap.putIfAbsent(e[0], new ArrayList<>());
            adjacencyListMap.get(e[0]).add(e[1]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, adjacencyListMap, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> adjacencyListMap, 
       Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        if (adjacencyListMap.containsKey(node)) {
            for (int next : adjacencyListMap.get(node)) {
                if (next == parent) continue;

                if (!dfs(next, node, adjacencyListMap, visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}
