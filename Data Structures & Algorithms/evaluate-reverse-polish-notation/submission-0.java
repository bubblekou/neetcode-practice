class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if ("+".equals(t)) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(value1 + value2);
            } else if ("-".equals(t)) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(value1 - value2);
            } else if ("*".equals(t)) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(value1 * value2);
            } else if ("/".equals(t)) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(value1 / value2);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.peek();
    }
}
