class MyQueue { 
    Stack <Integer> queue = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
       queue.push(x);
        
        
    }
    
    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        else {
            Stack <Integer> stack = new Stack<>();

            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
            int temp = stack.pop();
            
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
            return temp;
        }
        
    }
    
    public int peek() {
         if (queue.isEmpty()) {
            return -1;
        }
        else {
            Stack <Integer> stack = new Stack<>();

            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
            int temp = stack.peek();
            
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
            return temp;
           
        }

        
    }
    
    public boolean empty() {
        return queue.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */