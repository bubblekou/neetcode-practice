class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
        for (int[] pair : prerequisites) {
            adjacencyListMap.putIfAbsent(pair[0], new ArrayList<>());
            adjacencyListMap.get(pair[0]).add(pair[1]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adjacencyListMap, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> adjacencyListMap, 
       boolean[] visited, int current) {
        if (visited[current]) {
            return true;
        }

        visited[current] = true;
        if (adjacencyListMap.containsKey(current)) {
            for (int child : adjacencyListMap.get(current)) {
                if (hasCycle(adjacencyListMap, visited, child)) {
                    return true;
                }
            }
            adjacencyListMap.get(current).clear();
        }

        visited[current] = false;

        return false;
    }
}
