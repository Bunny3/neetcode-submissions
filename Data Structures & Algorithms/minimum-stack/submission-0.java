class MinStack {

    Stack<Integer> minimum;
    Stack<Integer> stack;

    public MinStack() {
        minimum = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(!minimum.isEmpty()){
            if(minimum.peek() >= val) {
                minimum.add(val);
            }
        } else {
            minimum.add(val);
        }
        stack.add(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            System.out.println("Empty Stack");
        }
        int value = stack.pop();
        if(value == minimum.peek()) {
            minimum.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}
