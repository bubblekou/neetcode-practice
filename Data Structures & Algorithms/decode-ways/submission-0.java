class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int twoBefore = 1;
        int oneBefore = 1;
        for (int i = 1; i < n; i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += oneBefore;
            }

            if (s.charAt(i - 1) == '0') {
              if (s.charAt(i) == '0') {
                // Invalue
                return 0;
              }
            }
            else {
                int value = Integer.parseInt(s.substring(i - 1, i + 1));
                if (value < 27) {
                    current += twoBefore;
                }
            }

            twoBefore = oneBefore;
            oneBefore = current;
        }

        return oneBefore;
    }
}
