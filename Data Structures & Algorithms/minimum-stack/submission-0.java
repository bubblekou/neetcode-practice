class MinStack {
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack ;

    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        valueStack.push(val);
        if (!minStack.isEmpty() && minStack.peek() < val) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        valueStack.pop();
        minStack.pop();
    }
    
    public int top() {
        if (valueStack.isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        return valueStack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        return minStack.peek();
    }
}
