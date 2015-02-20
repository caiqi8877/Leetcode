class MinStack {
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        } 
        stack.push(x);
        
    }

    public void pop() {
       if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
       
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
