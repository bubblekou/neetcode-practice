class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();

        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            adjacencyListMap.putIfAbsent(pair[1], new ArrayList<>());
            adjacencyListMap.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            finish++;
            if (adjacencyListMap.containsKey(current)) {
                for (int d : adjacencyListMap.get(current)) {
                    indegree[d]--;
                    if (indegree[d] == 0) {
                        q.offer(d);
                    }
                }
            }
        }

        return finish == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
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
