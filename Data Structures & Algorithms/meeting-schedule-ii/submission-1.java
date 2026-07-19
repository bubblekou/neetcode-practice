/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval itvr : intervals) {
            if (!heap.isEmpty() && heap.peek() <= itvr.start) {
                heap.poll();
            }
            heap.offer(itvr.end);
        }

        return heap.size();
    }

    private class Event {
        int timestamp;
        int increment;

        public Event(int timestamp, int increment) {
            this.timestamp = timestamp;
            this.increment = increment;
        }
    }

    public int minMeetingRooms2(List<Interval> intervals) {
        List<Event> events = new ArrayList<>();
        for (Interval itvr : intervals) {
            events.add(new Event(itvr.start, 1));
            events.add(new Event(itvr.end, -1));
        }

        Collections.sort(events, (a, b) -> {
            if (a.timestamp != b.timestamp) {
                return a.timestamp - b.timestamp;
            }

            return a.increment - b.increment;
        });

        int res = 0;
        int count = 0;
        for (Event evt : events) {
            count += evt.increment;
            res = Math.max(res, count);
        }

        return res;
    }
}
