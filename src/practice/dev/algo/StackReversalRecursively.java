package practice.dev.algo;

import java.util.Stack;

public class StackReversalRecursively {


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
