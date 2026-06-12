class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> values = new ArrayList<>();
        backtrack(nums, values, 0, 0, target, ans);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> values, int idx, int sum, int target, 
        List<List<Integer>> ans) {
        if (sum == target) {
            List<Integer> copy = new ArrayList<>(values);
            ans.add(copy);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (sum + nums[i] > target) continue;

            values.add(nums[i]);
            backtrack(nums, values, i, sum + nums[i], target, ans);
            values.removeLast();
        }
    }
}
