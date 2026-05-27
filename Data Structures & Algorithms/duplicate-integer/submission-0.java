class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int v : nums) {
            if (seen.contains(v)) {
                return true;
            }

            seen.add(v);
        }

        return false;
    }
}