package practice.dev.algo;

/**
 * 
 * @author dev
 *

Write a program function to detect loop in a linked list ->>>>
Given a linked list, check if the the linked list has loop or not. Below diagram shows a linked list with a loop.

Following are different ways of doing this
Use Hashing:
Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point, if NULL is reached then return false and if next of current node points to any of the previously stored nodes in Hash then return true.

Mark Visited Nodes:
This solution requires modifications to basic linked list data structure.  Have a visited flag with each node.  Traverse the linked list and keep marking visited nodes.  If you see a visited node again then there is a loop. This solution works in O(n) but requires additional information with each node.
A variation of this solution that doesn’t require modification to basic data structure can be implemented using hash.  Just store the addresses of visited nodes in a hash and if you see an address that already exists in hash then there is a loop.

Floyd’s Cycle-Finding Algorithm:
This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and other pointer by two.  If these pointers meet at some node then there is a loop.  If pointers do not meet then linked list doesn’t have loop.

Implementation of Floyd’s Cycle-Finding Algorithm:

 *
 */
public class CheckCycleInSingleLinkedList {

	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

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

	int detectLoop() {
		Node slow_p = head, fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				System.out.println("Found loop");
				return 1;
			}
		}
		return 0;
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		CheckCycleInSingleLinkedList llist = new CheckCycleInSingleLinkedList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		llist.detectLoop();
	}
}
