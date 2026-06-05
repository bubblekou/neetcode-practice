class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            System.out.println("low = "  + low + ", mid = " + mid + ", high = " + high);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[low] < nums[mid]) {
                if (nums[mid] < target || target < nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] > target || nums[high] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        // System.out.println("low = "  + low);
        return low < nums.length && nums[low] == target ? low : -1;
    }
}
