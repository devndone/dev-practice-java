package practice.dev.ds;

public class Stack<T> {

	private Object data[];
	private int currentIndex;

	public Stack(int initialCapacity) {
		data = new Object[initialCapacity];
		currentIndex = 0;
	}
	
	public Stack() {
		this(10);
	}
	
	private void reSizeStack() {
		Object newData[] = new Object[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public void push(T val) {
		if (currentIndex == data.length) {
			this.reSizeStack();
		}
		data[currentIndex++] = val;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		return (T)data[--currentIndex];
	}

	public int currentCapacity() {
		return this.data.length;
	}

	public int size() {
		return this.currentIndex;
	}

}
