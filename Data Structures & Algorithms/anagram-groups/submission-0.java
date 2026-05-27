class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);

            String key = new String(chs);
            groupMap.putIfAbsent(key, new ArrayList<>());
            groupMap.get(key).add(s);
        }

        List<List<String>> results = new ArrayList<>();
        for (String key : groupMap.keySet()) {
            results.add(groupMap.get(key));
        }

        return results;
    }
}
