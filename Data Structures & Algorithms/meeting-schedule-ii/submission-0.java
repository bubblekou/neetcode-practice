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
    private class Event {
        int timestamp;
        int increment;

        public Event(int timestamp, int increment) {
            this.timestamp = timestamp;
            this.increment = increment;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
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
