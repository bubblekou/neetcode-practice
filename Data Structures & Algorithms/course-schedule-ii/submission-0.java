class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjancyListMap = new HashMap<>();

        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            adjancyListMap.putIfAbsent(p[1], new ArrayList<>());
            adjancyListMap.get(p[1]).add(p[0]);
        }

        int[] ans = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) { 
                q.offer(i);
            }
        }

        int finished = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            ans[finished] = current;
            finished++;

            if (adjancyListMap.containsKey(current)) {
                for (int next : adjancyListMap.get(current)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }

        if (finished != numCourses) {
            return new int[0];
        }

        return ans;
    }
}
