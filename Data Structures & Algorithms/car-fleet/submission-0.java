class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) {
            return 0;
        }

        Integer[] ordered = new Integer[n];
        for (int i = 0; i < n; i ++) {
            ordered[i] = i;
        }

        Arrays.sort(ordered, (a, b) -> position[b] - position[a]);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(position[ordered[i]]);
        // }

        int ans = 1;
        double fleetEta = (double) (target - position[ordered[0]]) / speed[ordered[0]];
        for (int i = 1; i < n; i++) {
            double currentEta = (double) (target - position[ordered[i]]) / speed[ordered[i]];
            if (currentEta > fleetEta) {
                // Catch up to the fleet
                ans++;
            } else {
                fleetEta = currentEta;
            }
        }

        return ans;
    }
}
