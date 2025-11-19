package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> pila;
    private Stack<Integer> minimos;

    public static void main(String[] args) {
        /*MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println("Minimo: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top: " + minStack.top());
        System.out.println("Minimo: " + minStack.getMin());*/
        MinStack minStack = new MinStack();
        minStack.push(-100);
        minStack.push(-200);
        minStack.push(-300);
        minStack.push(-400);
        System.out.println("Minimo: " + minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println("Minimo: " + minStack.getMin());
    }

    public MinStack() {
        this.pila = new Stack<>();
        this.minimos = new Stack<>();
    }

    public void push(int val) {
        this.pila.push(val);
        if(this.minimos.isEmpty() || val <= this.minimos.peek()) {
            this.minimos.push(val);
        }
    }

    public void pop() {
        if(this.minimos.peek().equals(this.pila.pop())) {
            this.minimos.pop();
        }
    }

    public int top() {
        return this.pila.peek();
    }

    public int getMin() {
        return this.minimos.peek();
    }

}
