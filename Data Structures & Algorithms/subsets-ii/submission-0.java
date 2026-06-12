class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        for (int sz = 0; sz <= n; sz++) {
            backtrack(nums, sz, 0, new ArrayList<>(), ans);
        }

        return ans;
    }

    private void backtrack(int[] nums, int sz, int idx, List<Integer> values, List<List<Integer>> ans) {
        if (values.size() == sz) {
            List<Integer> copy = new ArrayList<>(values);
            ans.add(copy);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            values.add(nums[i]);
            backtrack(nums, sz, i + 1, values, ans);
            values.removeLast();
        }
    }
}
