class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> valueCountMap = new TreeMap<>();
        List<Integer> results = new ArrayList<>();

        int i = 0, j = 0;
        for (int v : nums) {
            valueCountMap.put(v, valueCountMap.getOrDefault(v, 0) + 1);
            if (j - i >= k) {
                if (valueCountMap.get(nums[i]) == 1) {
                    valueCountMap.remove(nums[i]);
                } else {
                    valueCountMap.put(nums[i], valueCountMap.get(nums[i]) - 1);
                }
                i++;
            }

            if (j - i == k - 1) {
                results.add(valueCountMap.lastKey());
            }

            j++;
        }

        int[] ans = new int[results.size()];
        for (int p = 0; p < results.size(); p++) {
            ans[p] = results.get(p);
        }

        return ans;
    }
}
