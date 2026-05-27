class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCountMap = new HashMap<>();

        for (int v : nums) {
            freqCountMap.put(v, freqCountMap.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freqCountMap.get(a) - freqCountMap.get(b));
 
        for (int v : freqCountMap.keySet()) {
            pq.offer(v);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
