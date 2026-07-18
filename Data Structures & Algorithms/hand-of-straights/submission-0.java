class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < hand.length; i++) {
            if (!freqCount.containsKey(hand[i])) {
                pq.offer(hand[i]);
            }
            freqCount.put(hand[i], freqCount.getOrDefault(hand[i], 0) + 1);
        }

        while (!freqCount.isEmpty() && !pq.isEmpty()) {
            int next = pq.peek();
            for (int i = 0; i < groupSize; i++) {
                if (!freqCount.containsKey(next)) return false;

                if (freqCount.get(next) == 1) freqCount.remove(next);
                else freqCount.put(next, freqCount.get(next) - 1);
                next++;
            }

            while (!pq.isEmpty() && !freqCount.containsKey(pq.peek())) {
                pq.poll();
            }
        }

        return freqCount.isEmpty();
    }
}
