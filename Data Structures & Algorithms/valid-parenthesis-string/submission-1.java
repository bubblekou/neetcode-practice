class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                if (leftStack.isEmpty() && starStack.isEmpty()) {
                    return false;
                }
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    starStack.pop();
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }

    public boolean checkValidString2(String s) {
       Stack<Character> stack = new Stack<>();
       int starAsOpenBracet = 0;
       for (char ch : s.toCharArray()) {
         if (ch == '(' || ch == '*') {
            stack.push(ch);
         } else {
            if (stack.isEmpty()) {
                return false;
            } else if (stack.peek() == '*') {
                starAsOpenBracet++;
                stack.pop();
            } else {
                stack.pop();
            }
         }
       }

       int starCount = 0; 
       int openBracket = 0;
       while (!stack.isEmpty()) {
         if (stack.peek() == '*') {
            starCount++;
         } else if (stack.peek() == '(') {
            if (starAsOpenBracet > 0) {
                starAsOpenBracet--;
            } else {
                openBracket++;
            }
         }

         stack.pop();
       }

       return openBracket <= starCount;
    }
}
