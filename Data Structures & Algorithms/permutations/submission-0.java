class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] taken = new boolean[n];
        backtrack(nums, n, taken, new ArrayList<>(), ans);  
        return ans;      
    }

    private void backtrack(int[] nums, int n, boolean[] taken, 
      List<Integer> values, List<List<Integer>> ans) {
        if (values.size() == n) {
            List<Integer> copy = new ArrayList<>(values);
            ans.add(copy);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                taken[i] = true;
                values.add(nums[i]);

                backtrack(nums, n, taken, values, ans);

                taken[i]= false;
                values.removeLast();
            }
        }
    }
}
