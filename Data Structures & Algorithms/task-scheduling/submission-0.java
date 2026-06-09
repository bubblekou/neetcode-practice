class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(i);
            }
        }

        int[] lastExeutionTime = new int[26];
        Arrays.fill(lastExeutionTime, -1);
        Queue<Integer> waitQueue = new ArrayDeque<>();
        
        int cycle = 0;
        while (!pq.isEmpty() || !waitQueue.isEmpty()) {
            // Poll task
            if (!pq.isEmpty()) {
                int task = pq.poll();
                freq[task]--;
                lastExeutionTime[task] = cycle;

                // Add current task to wait queue
                if (freq[task] > 0) {
                    waitQueue.add(task);
                }
            }

            cycle++;

            // Poll available task and add back to queue after time expired
            while (!waitQueue.isEmpty() && (lastExeutionTime[waitQueue.peek()] == -1 || 
                cycle - lastExeutionTime[waitQueue.peek()] > n)) {
                int available = waitQueue.poll();
                lastExeutionTime[available] = -1;
                pq.offer(available);
            }
        }

        return cycle;
    }
}
