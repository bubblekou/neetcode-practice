class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(height[j], rightMax[j + 1]);
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int edge = Math.min(leftMax[i - 1], rightMax[i + 1]);
            ans += Math.max(0, edge - height[i]);
        }

        return ans;
    }
}
