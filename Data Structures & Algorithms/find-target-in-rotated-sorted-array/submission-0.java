class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((nums[mid] < target && nums[low] < nums[high]) ||
                (nums[mid] > target && nums[low] > nums[high])) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
        }

        return nums[low] == target ? low : -1;
    }
}
