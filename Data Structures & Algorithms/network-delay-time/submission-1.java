class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            adjacencyListMap.putIfAbsent(times[i][0], new ArrayList<>());
            adjacencyListMap.get(times[i][0]).add(i);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (current[1] >= distance[current[0]]) {
                // Ignore longer path
                continue;
            }

            distance[current[0]] = current[1];
            // No descdent 
            if (!adjacencyListMap.containsKey(current[0])) continue;

            for (int nextIdx : adjacencyListMap.get(current[0])) {
                int nextTime = current[1] + times[nextIdx][2];
                int nextNode = times[nextIdx][1];
                pq.offer(new int[] {nextNode, nextTime});
            }
        }

        int longest = 0;
        for (int i = 1; i <= n; i++) {
            longest = Math.max(longest, distance[i]);
        }

        return longest == Integer.MAX_VALUE ? -1 : longest;
    }
}
