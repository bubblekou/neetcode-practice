class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;

        // Monitonic increasing stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int end = stack.pop();
                ans = Math.max(ans, stack.isEmpty() ? i : (i - stack.peek() - 1) * heights[end]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int start = stack.pop();
            ans = Math.max(ans, (stack.isEmpty() ? n : n - stack.peek() - 1) * heights[start]);
        }

        return ans;
    }

    public int largestRectangleArea_n_square(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int lowest = heights[i];
            for (int j = i; j < n; j++) {
                lowest = Math.min(lowest, heights[j]);
                ans = Math.max(ans, (j - i + 1) * lowest);
            }
        }

        return ans;
    }
}
