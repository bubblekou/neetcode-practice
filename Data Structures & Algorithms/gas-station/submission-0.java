class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;

        int tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i];
            total -= cost[i];
            
            tank = total;
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }

        return total < 0 ? -1 : start;
    }
}
