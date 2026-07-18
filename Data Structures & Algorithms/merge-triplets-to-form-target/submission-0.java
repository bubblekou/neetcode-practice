class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> ignoreSet = new HashSet<>();
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0]) {
                ignoreSet.add(i);
            }
            if (triplets[i][1] > target[1]) {
                ignoreSet.add(i);
            }
            if (triplets[i][2] > target[2]) {
                ignoreSet.add(i);
            }
        }

        boolean hasA = false, hasB = false, hasC = false;
        for (int i = 0; i < triplets.length; i++) {
            if (ignoreSet.contains(i)) continue;
            if (!hasA && triplets[i][0] == target[0]) hasA = true;
            if (!hasB && triplets[i][1] == target[1]) hasB = true;
            if (!hasC && triplets[i][2] == target[2]) hasC = true;
        }

        return hasA && hasB && hasC;
    }
}
