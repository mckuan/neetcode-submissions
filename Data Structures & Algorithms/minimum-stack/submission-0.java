class MinStack {


    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.size() == 0) minStack.push(val);
        else minStack.push(Math.min(val,minStack.peek()));
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// minStack keeps the minimum at each point ,if i pop x, what is the minimum at x?
