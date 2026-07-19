class MyQueue {
    Stack<Integer> a = new Stack<>(), b = new Stack<>();
    public void push(int x) {
        a.push(x);
    }
    public int pop() {
        if (b.empty())
        while (!a.empty()) b.push(a.pop());
        return b.pop();
    }
    public int peek() {
        if (b.empty())
        while (!a.empty()) b.push(a.pop());
        return b.peek();
    }
    public boolean empty() {
        return a.empty() && b.empty();
    }
}