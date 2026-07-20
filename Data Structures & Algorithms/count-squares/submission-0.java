class CountSquares {
    private Map<Integer, Map<Integer, Integer>> pointMap;

    private Map<Integer, Set<Integer>> yToxMap;

    public CountSquares() {
        pointMap = new HashMap<>();
        yToxMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        pointMap.putIfAbsent(point[0], new HashMap<>());
        Map<Integer, Integer> yMap = pointMap.get(point[0]);
        yMap.put(point[1], yMap.getOrDefault(point[1], 0) + 1);

        yToxMap.putIfAbsent(point[1], new HashSet<>());
        yToxMap.get(point[1]).add(point[0]);
    }
    
    public int count(int[] point) {
        Map<Integer, Integer> yMap = pointMap.get(point[0]);
        if (yMap == null) {
            // No additional vertical point
            return 0;
        }

        int total = 0;
        for (int y : yMap.keySet()) {
            // Ignore self
            if (y == point[1]) continue;

            // count of (point[0], y)
            int count1 = yMap.get(y);

            // Find x given each y
            for (int x : yToxMap.get(y)) {
                if (x == point[0]) continue;

                Map<Integer, Integer> yMap2 = pointMap.get(x);
                if (!yMap2.containsKey(point[1]) || !yMap2.containsKey(y)) continue;

                // count of (x, p[1])
                int count2 = yMap2.get(point[1]);
                // count of (x, y) 
                int count3 = yMap2.get(y);

                total += count1 * count2 * count3;
            }
        }

        return total;
    }
}
