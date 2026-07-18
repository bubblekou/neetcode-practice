class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n - 1, end = 0;
        int tank = gas[start] - cost[start];
        while (start > end) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }

        return tank >= 0 ? start : -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;

        int tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i];
            total -= cost[i];

            tank += gas[i];
            tank -= cost[i];            
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }

        return total < 0 ? -1 : start;
    }
}
