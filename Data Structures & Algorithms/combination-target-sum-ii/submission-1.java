class Solution {
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     Arrays.sort(candidates);

    //     List<List<Integer>> res = new ArrayList<>();
    //     res.add(new ArrayList<>());
    //     for (int num : nums) {
    //         int sz = res.size();
    //         for (int i = 0; i < sz; i++) {
    //             List<Integer> subset = new ArrayList<>(res.get(i));
    //             subset.add(num);
    //             res.add(subset);
    //         }
    //     }

    //     return res;
    // }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> values = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, values, 0, 0, ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<Integer> values, 
      int idx, int sum, List<List<Integer>> ans) {
        if (sum == target) {
            List<Integer> copy = new ArrayList<>(values);
            ans.add(copy);
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            values.add(candidates[i]);
            backtrack(candidates, target, values, i + 1, sum + candidates[i], ans);
            values.removeLast();
        }
    }
}
