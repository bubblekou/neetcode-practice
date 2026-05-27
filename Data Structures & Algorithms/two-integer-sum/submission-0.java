class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indiceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if (indiceMap.containsKey(expected)) {
                return new int[]{indiceMap.get(expected), i};
            }
            indiceMap.put(nums[i], i);
        }

        return null;
    }
}
