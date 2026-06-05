class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[low] && nums[low] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[low]) {
                high = mid;
            } else {
                break;
            }
        }

        return nums[high];
    }
}
