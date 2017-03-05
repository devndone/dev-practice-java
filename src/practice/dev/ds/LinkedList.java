package practice.dev.ds;

class LinkedList {

	public static Node head;

	public static Node a, b;

	public class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

	public Node add(int value) {

		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			return newNode;
		}

		newNode.next = head;
		head = newNode;

		return newNode;
	}

	Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	/* Utility functions */

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * 
	 * Method 1 (Check one by one) We know that Floyd’s Cycle detection
	 * algorithm terminates when fast and slow pointers meet at a common point.
	 * We also know that this common point is one of the loop nodes (2 or 3 or 4
	 * or 5 in the above diagram). We store the address of this in a pointer
	 * variable say ptr2. Then we start from the head of the Linked List and
	 * check for nodes one by one if they are reachable from ptr2. When we find
	 * a node that is reachable, we know that this node is the starting node of
	 * the loop in Linked List and we can get pointer to the previous of this
	 * node.
	 * 
	 * @param node
	 * @return
	 */
	// Function that detects loop in the list
	int detectAndRemoveLoopM1(Node node) {
		Node slow = node, fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast meet at same point then loop is present
			if (slow == fast) {
				removeLoopM1(slow, node);
				return 1;
			}
		}
		return 0;
	}

	// Function to remove loop
	void removeLoopM1(Node loop, Node curr) {
		Node ptr1 = null, ptr2 = null;

		/*
		 * Set a pointer to the beging of the Linked List and move it one by one
		 * to find the first node which is part of the Linked List
		 */
		ptr1 = curr;
		while (1 == 1) {

			/*
			 * Now start a pointer from loop_node and check if it ever reaches
			 * ptr2
			 */
			ptr2 = loop;
			while (ptr2.next != loop && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

			/*
			 * If ptr2 reahced ptr1 then there is a loop. So break the loop
			 */
			if (ptr2.next == ptr1) {
				break;
			}

			/* If ptr2 did't reach ptr1 then try the next node after ptr1 */
			ptr1 = ptr1.next;
		}

		/*
		 * After the end of loop ptr2 is the last node of the loop. So make next
		 * of ptr2 as NULL
		 */
		ptr2.next = null;
	}

	/**
	 * 
	 * Method 2 (Better Solution) This method is also dependent on Floyd’s Cycle
	 * detection algorithm. 1) Detect Loop using Floyd’s Cycle detection algo
	 * and get the pointer to a loop node. 2) Count the number of nodes in loop.
	 * Let the count be k. 3) Fix one pointer to the head and another to kth
	 * node from head. 4) Move both pointers at the same pace, they will meet at
	 * loop starting node. 5) Get pointer to the last node of loop and make next
	 * of it as NULL.
	 * 
	 * @param node
	 * @return
	 */
	// Function that detects loop in the list
	int detectAndRemoveLoopM2(Node node) {
		Node slow = node, fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast meet at same point then loop is present
			if (slow == fast) {
				removeLoopM2(slow, node);
				return 1;
			}
		}
		return 0;
	}

	// Function to remove loop
	void removeLoopM2(Node loop, Node head) {
		Node ptr1 = loop;
		Node ptr2 = loop;

		// Count the number of nodes in loop
		int k = 1, i;
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}

		// Fix one pointer to head
		ptr1 = head;

		// And the other pointer to k nodes after head
		ptr2 = head;
		for (i = 0; i < k; i++) {
			ptr2 = ptr2.next;
		}

		/*
		 * Move both pointers at the same pace, they will meet at loop starting
		 * node
		 */
		while (ptr2 != ptr1) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		// Get pointer to the last node
		ptr2 = ptr2.next;
		while (ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}

		/*
		 * Set the next node of the loop ending node to fix the loop
		 */
		ptr2.next = null;
	}

	/**
	 * 
	 * Method 3 (Optimized Method 2: Without Counting Nodes in Loop) We do not
	 * need to count number of nodes in Loop. After detecting the loop, if we
	 * start slow pointer from head and move both slow and fast pointers at same
	 * speed until fast don’t meet, they would meet at the beginning of linked
	 * list.
	 *
	 */
	// Function that detects loop in the list
	void detectAndRemoveLoopM3(Node node) {
		Node slow = node;
		Node fast = node.next;

		// Search for loop using slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			slow = node;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */

		}
	}

	Node sortedmerge(Node node1, Node node2) {

		// if both the nodes are null
		if (node1 == null && node2 == null) {
			return null;
		}

		// resultant node
		Node res = null;

		// if both of them have nodes present traverse them
		while (node1 != null && node2 != null) {

			// Now compare both nodes current data
			if (node1.data <= node2.data) {
				Node temp = node1.next;
				node1.next = res;
				res = node1;
				node1 = temp;
			} else {
				Node temp = node2.next;
				node2.next = res;
				res = node2;
				node2 = temp;
			}
		}

		// If second list reached end, but first list has
		// nodes. Add remaining nodes of first list at the
		// front of result list
		while (node1 != null) {
			Node temp = node1.next;
			node1.next = res;
			res = node1;
			node1 = temp;
		}

		// If first list reached end, but second list has
		// node. Add remaining nodes of first list at the
		// front of result list
		while (node2 != null) {
			Node temp = node2.next;
			node2.next = res;
			res = node2;
			node2 = temp;
		}

		return res;

	}

	public void reverse() {

		Node headNode = this.head;
		Node prevNode = null;
		Node nextNode = null;
		while (headNode != null) {
			nextNode = headNode.next;// nn=2//nn=3
			headNode.next = prevNode;// hn=null//hn=1
			prevNode = headNode;// t=1//t=2
			headNode = nextNode;// h=2//h=3
		}

		this.head = prevNode;
	}

	public void reverseRecusive() {

		reverseRecusiveHelper(this.head, null);
	}

	public void reverseRecusiveHelper(Node head, Node prev) {

		if (head == null) {
			this.head = prev;
			return;
		}
		reverseRecusiveHelper(head.next, head);
		head.next = prev;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append("[");
		Node current = this.head;
		while (current != null) {
			sb.append(current.data);
			current = current.next;

			if (current != null) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	void printlist(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {

		LinkedList llist = new LinkedList();

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		llist.push(9);
		llist.push(8);
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("Given Linked List");
		llist.printList();

		llist.head = llist.reverse(llist.head, 3);

		System.out.println("Reversed list");
		llist.printList();

		LinkedList ll = new LinkedList();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);

		System.out.println(ll);
		ll.reverse();
		System.out.println(ll);
		ll.reverseRecusive();
		System.out.println(ll);

		LinkedList list = new LinkedList();
		Node result = null;

		/*
		 * Let us create two sorted linked lists to test the above functions.
		 * Created lists shall be a: 5->10->15 b: 2->3->20
		 */
		list.a = new LinkedList().new Node(5);
		list.a.next = new LinkedList().new Node(10);
		list.a.next.next = new LinkedList().new Node(15);

		list.b = new LinkedList().new Node(2);
		list.b.next = new LinkedList().new Node(3);
		list.b.next.next = new LinkedList().new Node(20);

		System.out.println("List a before merge :");
		list.printlist(a);
		System.out.println("");
		System.out.println("List b before merge :");
		list.printlist(b);

		// merge two sorted linkedlist in decreasing order
		result = list.sortedmerge(a, b);
		System.out.println("");
		System.out.println("Merged linked list : ");
		list.printlist(result);

		LinkedList listM1 = new LinkedList();
		list.head = new LinkedList().new Node(50);
		list.head.next = new LinkedList().new Node(20);
		list.head.next.next = new LinkedList().new Node(15);
		list.head.next.next.next = new LinkedList().new Node(4);
		list.head.next.next.next.next = new LinkedList().new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoopM1(head);
		System.out.println("Linked List after removing loop : ");
		list.printlist(head);

		LinkedList listM2 = new LinkedList();
		list.head = new LinkedList().new Node(50);
		list.head.next = new LinkedList().new Node(20);
		list.head.next.next = new LinkedList().new Node(15);
		list.head.next.next.next = new LinkedList().new Node(4);
		list.head.next.next.next.next = new LinkedList().new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoopM2(head);
		System.out.println("Linked List after removing loop : ");
		list.printlist(head);

		LinkedList listM3 = new LinkedList();
		list.head = new LinkedList().new Node(50);
		list.head.next = new LinkedList().new Node(20);
		list.head.next.next = new LinkedList().new Node(15);
		list.head.next.next.next = new LinkedList().new Node(4);
		list.head.next.next.next.next = new LinkedList().new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoopM3(head);
		System.out.println("Linked List after removing loop : ");
		list.printlist(head);

	}
}
