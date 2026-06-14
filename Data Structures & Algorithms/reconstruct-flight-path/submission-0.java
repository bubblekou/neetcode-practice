class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        boolean[] used = new boolean[n];

        Map<String, List<Integer>> adjancyListMap = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> t = tickets.get(i);
            String from = t.get(0);
            adjancyListMap.putIfAbsent(from, new ArrayList<>());
            adjancyListMap.get(from).add(i);
        }

        for (String from : adjancyListMap.keySet()) {
            List<Integer> toTickets = adjancyListMap.get(from);
            Collections.sort(toTickets, (a, b) -> 
                 tickets.get(a).get(1).compareTo(tickets.get(b).get(1)));
        }

        List<String> res = new ArrayList<>();
        if (dfs(tickets, n, adjancyListMap, used, "JFK", res)) {
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs(List<List<String>> tickets, int n,
      Map<String, List<Integer>> adjancyListMap, 
      boolean[] used, String current, List<String> res) {
        res.add(current);
        if (res.size() == n + 1) {
            return true;
        }

        if (!adjancyListMap.containsKey(current)) {
            res.removeLast();
            return false;
        }

        for (int nextIdx : adjancyListMap.get(current)) {
            if (used[nextIdx]) continue;

            used[nextIdx] = true;
            if (dfs(tickets, n, adjancyListMap, used, tickets.get(nextIdx).get(1), res)) {
                return true;
            }

            used[nextIdx] = false;
        }

        res.removeLast();
        return false;
    }
}
