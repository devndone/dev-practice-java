package practice.dev.algo;

public class StackUsingLinkedList<E> {

	private Node<E> elementList;
	private Node<E> topElement;
	private int elementCount = 0;
	
	public int size() {
		return elementCount;
	}
	
	public boolean isEmpty() {
		return topElement == null;
	}
	
	public E top() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Underlow Exception");
		}
		return topElement.getItem();
	}
	
	public void push(E data) throws Exception {
		try {
			elementList = new Node<E>(data, topElement);
			topElement = elementList;
			elementCount++;
		} catch(Throwable t) {
			new Exception("Stack Overflow Exception");
		}
	}
	
	public E pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Underlow Exception");
		}
		E data = elementList.getItem();
		topElement = elementList.getNext();
		elementList.setNext(null);
		elementList = topElement;
		elementCount--;
		return data;
	}
	
	private class Node<E> {
        
		E item;
        Node<E> next;

        Node<E> getNext() {
			return next;
		}

		void setNext(Node<E> next) {
			this.next = next;
		}

		E getItem() {
			return item;
		}

		Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
	 
}
