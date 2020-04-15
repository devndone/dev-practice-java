package practice.dev.ds;

import java.util.Stack;

public class QueueUsing1StackWithReverseTop<T> {

	private Stack<T> stack;
	int size = 0;

	public QueueUsing1StackWithReverseTop() {
		stack = new Stack<T>();
	}

	public T enqueue(T element) {
		stack.push(element);
		size++;
		return element;
	}

	public T dequeue() {
		if (size > 0)
			size--;
		return getReverseTop();
	}

	public T getReverseTop() {
		if (stack.size() == 0)
			return null;
		T res = stack.pop();
		T top = getReverseTop();
		if (top == null)
			return res;
		else {
			stack.push(res);
			return top;
		}
	}

	public static void main(String[] args) {

		QueueUsing1StackWithReverseTop<Integer> ds = new QueueUsing1StackWithReverseTop<Integer>();
		ds.enqueue(2);
		ds.enqueue(3);
		ds.enqueue(4);
		ds.enqueue(5);
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		ds.enqueue(6);
		ds.enqueue(7);
		ds.enqueue(8);
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
	}

}
