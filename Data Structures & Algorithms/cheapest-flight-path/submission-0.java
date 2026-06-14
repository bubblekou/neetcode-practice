class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            adjacencyListMap.putIfAbsent(flights[i][0], new ArrayList<>());
            adjacencyListMap.get(flights[i][0]).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(flights, adjacencyListMap, src, dst, k + 1, 0, visited, ans);

        if (ans.isEmpty()) {
            return -1;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < ans.size(); i++) {
            minCost = Math.min(minCost, ans.get(i));
        }

        return minCost;
    }

    private void dfs(int[][] flights, Map<Integer, List<Integer>> adjacencyListMap, 
      int current, int dst, int k, int cost, boolean[] visited, List<Integer> ans) {
        if (current == dst) {
            ans.add(cost);
            return;
        }

        if (visited[current] || !adjacencyListMap.containsKey(current) || k == 0) {
            return;
        }
        
        visited[current] = true;
        for (int idx : adjacencyListMap.get(current)) {
            dfs(flights, adjacencyListMap, flights[idx][1], dst, k - 1, cost + flights[idx][2],
              visited, ans);
        }
        visited[current] = false;
    }
}
