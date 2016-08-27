package practice.dev.ds;

import java.util.Stack;

import practice.dev.algo.UnderflowException;

public class QueueUsing1StackWithInsertAtBottom extends Object {

	private Stack<Integer> stack = new Stack<>();
	private volatile Integer res;

	public void enq(Integer in) {
		synchronized (stack) {
			insertAtBottom(stack, in);
		}
	}

	public Integer deq() {
		synchronized (stack) {
			this.res = null;
			if (stack.isEmpty()) {
				throw new UnderflowException("");
			}
			this.res = stack.pop();
		}
		return this.res;
	}

	private void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		reverse(stack);
		insertAtBottom(stack, temp);
	}

	private void insertAtBottom(Stack<Integer> stack, int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
		return;
	}
}
