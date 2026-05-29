class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> valueSet = new HashSet<>();
        for (int v : nums) {
            valueSet.add(v);
        } 

        int ans = 0;

        Map<Integer, Integer> snakeLengthMap = new HashMap<>();
        List<Integer> valueList = new ArrayList<>();
        valueList.addAll(valueSet);

        Set<Integer> processed = new HashSet<>();
        for (int v : valueList) {
            if (processed.contains(v)) {
                continue;
            }
            processed.add(v);
            int len = 0;
            int currentValue = v;
            while (valueSet.contains(currentValue)) {
                len++;
 
                valueSet.remove(currentValue);
                processed.add(currentValue);
                currentValue--;
            }

            if (snakeLengthMap.containsKey(currentValue)) {
                len += snakeLengthMap.get(currentValue);
            }

            snakeLengthMap.put(v, len);
            ans = Math.max(ans, len);            
        }

        return ans;
    }

    /*public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = 1;

        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                count++;
                ans = Math.max(ans, count);
            } else if (nums[i] != prev) {
                count = 1;
            }
            prev = nums[i];
        }

        return ans;
    }*/
}
