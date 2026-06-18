class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        return dfs(s1, len1, 0, s2, len2, 0, s3);       
    }

    private boolean dfs(String s1, int len1, int i, String s2, int len2, int j, 
      String s3) {
        if (i == len1 && j == len2) {
            return true;
        }

        if (i < len1 && s3.charAt(i + j) == s1.charAt(i)) {
            if (dfs(s1, len1, i + 1, s2, len2, j, s3)) {
                return true;
            }
        }

        if (j < len2 && s3.charAt(i + j) == s2.charAt(j)) {
            if (dfs(s1, len1, i, s2, len2, j + 1, s3)) {
                return true;
            }
        }

        return false;
    }
}
