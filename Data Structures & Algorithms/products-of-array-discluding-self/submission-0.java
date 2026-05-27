class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixProduct = new int[n + 1];
        prefixProduct[0] = 1;

        for (int i = 0; i < n; i++) {
            prefixProduct[i + 1] = prefixProduct[i] * nums[i];
        }

        int[] postfixProduct = new int[n + 1];
        postfixProduct[n] = 1;
        for (int i = n - 1; i >= 0; i--){
            postfixProduct[i] = postfixProduct[i + 1] * nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefixProduct[i] * postfixProduct[i + 1];
        }

        return ans;
    }
}  
