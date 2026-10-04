class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        Integer[] taskByStartTime = new Integer[n];
        for (int i = 0; i < n; i++) {
            taskByStartTime[i] = i;
        }

        Arrays.sort(taskByStartTime, (a, b) -> Integer.compare(tasks[a][0], tasks[b][0]));

        // System.out.println(Arrays.toString(taskByStartTime));

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int priorityDiff = tasks[a][1] - tasks[b][1];
            if (priorityDiff != 0) {
                return priorityDiff;
            }

            return a - b;
        });

        // Enqueue all tasks at start time
        int current = 0;
        while (current == 0 || (current < n && tasks[taskByStartTime[current]][0] == tasks[taskByStartTime[current - 1]][0])) {
            queue.offer(taskByStartTime[current++]);
        }

        int[] ans = new int[n];
        int i = 0;
        int clock = tasks[taskByStartTime[0]][0];
        while (!queue.isEmpty()) {
            int t = queue.poll();
            ans[i++] = t;

            clock += tasks[t][1];

            // System.out.println("Clock = " + clock + ", current = " + current);
            while (current < n && tasks[taskByStartTime[current]][0] <= clock) {
                queue.offer(taskByStartTime[current++]);
            }

            // Next start is after current
        }

        return ans;
    }
}