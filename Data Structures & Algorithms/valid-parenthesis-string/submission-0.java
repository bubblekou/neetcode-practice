class Solution {
    public boolean checkValidString(String s) {
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
