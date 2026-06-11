class MedianFinder {
    private PriorityQueue<Integer> upper;
    private PriorityQueue<Integer> lower;

    public MedianFinder() {
        upper = new PriorityQueue<>();
        lower = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (upper.size() <= lower.size()) {
            upper.offer(num);
        } else {
            lower.offer(num);
        }

        if (upper.size() > 0 && lower.size() > 0 && upper.peek() < lower.peek()) {
            int tmp = upper.poll();
            upper.offer(lower.poll());
            lower.offer(tmp);
        }
    }
    
    public double findMedian() {
        if (upper.size() > lower.size()) {
            return upper.peek();
        } else {
            return ((double) upper.peek() + lower.peek()) / 2;
        }
    }
}
