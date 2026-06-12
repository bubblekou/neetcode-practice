class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> visited = new ArrayList<>();
        for (int sz = 0; sz <= nums.length; sz++) {
            backtrack(nums, 0, visited, sz, ans);
        }

        return ans;
    }

    private void backtrack(int[] nums, int current, List<Integer> visited, 
    int limit, List<List<Integer>> ans) {
        if (visited.size() == limit) {
            List<Integer> copy = new ArrayList<>(visited);
            ans.add(copy);
            return;
        } 

        for (int start = current; start < nums.length; start++) {
            visited.add(nums[start]);
            backtrack(nums, start + 1, visited, limit, ans);
            visited.removeLast();
        }
    }
}
