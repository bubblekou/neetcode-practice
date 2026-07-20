class Solution {
    public String multiply(String num1, String num2) {
        if ((num1.length() == 1 && num1.charAt(0) == '0') ||
            (num2.length() == 1 && num2.charAt(0) == '0')) {
                return "0";
        }

        List<Integer> value1 = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            value1.add(num1.charAt(i) - '0');
        }

        List<Integer> value2 = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            value2.add(num2.charAt(i) - '0');
        }

        List<Integer> value = new ArrayList<>();
        for (int i = 0; i < value1.size(); i++) {
            int carryOver = 0;
            int k = i;
            for (int j = 0; j < value2.size(); j++) {
                int v = value1.get(i) * value2.get(j);
                v += carryOver;
                if (k >= value.size()) {
                    value.add(0);
                } 

                v += value.get(k);
                carryOver = v / 10;
                value.set(k, v % 10);

                k++;
            }

            // More carryover
            while (carryOver > 0) {
                if (k >= value.size()) {
                    value.add(0);
                } 
                int v = value.get(k);
                v += carryOver;
                carryOver = v / 10;
                value.set(k, v % 10);
                k++;
            }
        }

        char[] chs = new char[value.size()];
        for (int i = 0; i < value.size(); i++) {
            chs[i] = (char) ('0' + value.get(value.size() - 1 - i));
        }

        return new String(chs);
    }
}
