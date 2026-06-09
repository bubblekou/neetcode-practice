class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int v : nums) {
            if (pq.size() < k) {
                pq.offer(v);
            } else if (v > pq.peek()) {
                pq.poll();
                pq.offer(v);
            }
        }
    }
    
    public int add(int val) {
        if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
