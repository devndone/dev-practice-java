package practice.dev.problemsolving;

public class PhraseMaxHeap implements PriorityQueue {

	/**
	 * Construct the binary heap.
	 */
	public PhraseMaxHeap() {
		currentSize = 0;
		array = new Comparable[DEFAULT_CAPACITY + 1];
	}

	/**
	 * Construct the binary heap from an array.
	 * 
	 * @param items
	 *            the inital items in the binary heap.
	 */
	public PhraseMaxHeap(Comparable[] items) {
		currentSize = items.length;
		array = new Comparable[items.length + 1];

		for (int i = 0; i < items.length; i++)
			array[i + 1] = items[i];
		buildHeap();
	}

	/**
	 * Insert into the priority queue. If Duplicate, increment the count of the
	 * phrase.
	 * 
	 * @param x
	 *            the item to insert.
	 * @return null, signifying that decreaseKey cannot be used.
	 */
	public PriorityQueue.Position insert(Comparable x) {
		if (currentSize + 1 == array.length)
			doubleArray();

		// Percolate up
		int hole = ++currentSize;
		array[0] = x;

		for (; x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;

		return null;
	}

	/**
	 * @throws UnsupportedOperationException
	 *             because no Positions are returned by the insert method for
	 *             BinaryHeap.
	 */
	public void decreaseKey(PriorityQueue.Position p, Comparable newVal) {
		throw new UnsupportedOperationException(
				"Cannot use decreaseKey for binary heap");
	}

	/**
	 * Find the smallest item in the priority queue.
	 * 
	 * @return the smallest item.
	 * @throws UnderflowException
	 *             if empty.
	 */
	public Comparable findMin() {
		if (isEmpty())
			throw new UnderflowException("Empty binary heap");
		return array[1];
	}

	/**
	 * Remove the smallest item from the priority queue.
	 * 
	 * @return the smallest item.
	 * @throws UnderflowException
	 *             if empty.
	 */
	public Comparable deleteMin() {
		Comparable minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);

		return minItem;
	}

	/**
	 * Establish heap order property from an arbitrary arrangement of items.
	 * Runs in linear time.
	 */
	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--)
			percolateDown(i);
	}

	/**
	 * Test if the priority queue is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/**
	 * Returns size.
	 * 
	 * @return current size.
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Make the priority queue logically empty.
	 */
	public void makeEmpty() {
		currentSize = 0;
	}

	private static final int DEFAULT_CAPACITY = 100;

	private int currentSize; // Number of elements in heap
	private Comparable[] array; // The heap array

	/**
	 * Internal method to percolate down in the heap.
	 * 
	 * @param hole
	 *            the index at which the percolate begins.
	 */
	private void percolateDown(int hole) {
		int child;
		Comparable tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize
					&& array[child + 1].compareTo(array[child]) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}

	/**
	 * Internal method to extend array.
	 */
	private void doubleArray() {
		Comparable[] newArray;

		newArray = new Comparable[array.length * 2];
		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];
		array = newArray;
	}

	// Test program
	public static void main(String[] args) {

		int numItems = 1000;
		PhraseMaxHeap h1 = new PhraseMaxHeap();
		Phrase[] items = new Phrase[numItems - 1];

		int i = 37;
		int j;

		for (i = 37, j = 0; i != 0; i = (i + 37) % numItems, j++) {
			h1.insert(new Phrase(Integer.toString(i)));
			items[j] = new Phrase(Integer.toString(i));
		}

		for (i = 1; i < numItems; i++)
			if (Integer.valueOf(((Phrase) h1.deleteMin()).toString())
					.intValue() != i)
				System.out.println("Oops! " + i);

		PhraseMaxHeap h2 = new PhraseMaxHeap(items);
		for (i = 1; i < numItems; i++)
			if (Integer.valueOf(((Phrase) h2.deleteMin()).toString())
					.intValue() != i)
				System.out.println("Oops! " + i);
	}
}
