import java.util.Stack;

// 还是要考虑Integer的问题
public class MinStack {
  private Stack<Integer> stack = new Stack<Integer>();
  private Stack<Integer> minstack = new Stack<Integer>();

  public MinStack() {

  }

  public void push(int x) {
    this.stack.push(x);
    if (this.minstack.isEmpty() || this.minstack.peek() >= x) {
      this.minstack.push(x);
    }
  }

  public void pop() {
    if (!this.stack.isEmpty()) {
      int top = this.stack.pop();
      if (!this.minstack.isEmpty() && top == this.minstack.peek())
        this.minstack.pop();
    }
  }

  public int top() {
    return this.stack.peek();
  }

  public int getMin() {
    return this.minstack.peek();
  }

  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(-2);
    stack.push(0);
    stack.push(-3);
    System.out.println("Checking case1: " + (stack.getMin() == -3));
    stack.pop();
    System.out.println("Checking case2: " + (stack.top() == 0));
    System.out.println("Checking case3: " + (stack.getMin() == -2));

    MinStack stack2 = new MinStack();
    stack2.push(2);
    stack2.push(0);
    stack2.push(3);
    stack2.push(0);
    System.out.println(stack2.getMin());
    stack2.pop();
    System.out.println(stack2.getMin());
    stack2.pop();
    System.out.println(stack2.getMin());
    stack2.pop();
    System.out.println(stack2.getMin());
  }

}
