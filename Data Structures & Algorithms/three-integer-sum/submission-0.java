class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            // Advance i by i in case of duplicated value
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1, k = n - 1;
            int target = -nums[i];

            while (j < k) {            
                // Advance j or k if there are duplicates    
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                } else if (k < n - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                int sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                    continue;
                } else if (sum > target) {
                    k--;
                    continue;
                }

                List<Integer> triple = new ArrayList<>();
                triple.add(nums[i]);
                triple.add(nums[j]);
                triple.add(nums[k]);
                result.add(triple);

                j++;
            }
        }

        return result;
    }
}
