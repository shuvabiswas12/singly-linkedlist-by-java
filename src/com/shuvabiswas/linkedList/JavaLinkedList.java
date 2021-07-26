package com.shuvabiswas.linkedList;


public class JavaLinkedList {
	Node root;
	
	/** This node class should be static so that main method can access this without creating-
	object */
	
	static class Node {
		int data;
		Node next;
		
		// constructor for create a new node
		// next is by default initialized as null
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	// method to insert a new node
	public static JavaLinkedList insert(JavaLinkedList list, int data) {
		
		// create a new node with given data
		Node newNode = new Node(data);
		newNode.next = null;
		
		// if the linkedList is empty then make the new node as root
		if (list.root == null) {
			list.root = newNode;
		}
		else {
			// traverse till the last node and insert the new node there
			Node lastNode = list.root;
			while(lastNode.next != null) {
				lastNode = lastNode.next;
			}
			
			// insert the new node as the last node
			lastNode.next = newNode;
		}
		
		// return the list
		return list;
	}
	
	
	public static JavaLinkedList insertAtPosition(JavaLinkedList list, int data, int position) {
		Node newNode, currentNode = list.root, preNode = null;
		
		newNode = new Node(data);
		
		newNode.data = data;
		newNode.next = null;
		
		if (list.root == null && position == 0) {
			list.root = newNode;
			System.out.println("new node inserted.");
			return list;
		}	
		else if (list.root == null && position != 0) {
			System.out.println("List is empty.");
			return list;
		}
		else {
			int counter = 0;
			while(currentNode != null) {
				if (counter++ == position) {
					newNode.next = currentNode;
					preNode.next = newNode;
					System.out.println("Inserted");
					return list;
				}
				else {
					preNode = currentNode;
					currentNode = currentNode.next;
				}
			}
			
			if (currentNode == null) {
				System.out.println("can not inserted at " + position);
			}
			
		}
		
		return list;
	}
	
	
	// method to traverse the list and show the items
	public static void showList(JavaLinkedList list) {
		Node currentNode = list.root;
		System.out.println("Linkedlist: ");
		
		while(currentNode != null) {
			System.out.print(currentNode.data + "-> ");
			
			// go to the next node
			currentNode = currentNode.next;
		}
	}
	
	
	// method to delete an item by key
	public static JavaLinkedList deleteByKey(JavaLinkedList list, int key) {
		Node currentNode = list.root, pre_node = null;
		
		// case 1
		// if root node itself holds the key to be deleted
		if (currentNode != null && currentNode.data == key) {
			list.root = currentNode.next;
			System.out.println(key + " Found and deleted.");
			return list;
		}
		
		// case 2
		// if the key at somewhere other than at head
		
		// search for the key to be deleted
		// keep track of the previous node
		// as it id needed to change currentNode.next
		while(currentNode != null && currentNode.data != key) {
			// if current node does not hold key
			// continue to next node
			pre_node = currentNode;
			currentNode = currentNode.next;
		}
		
		// if the key was present it should be at current node
		// therefore current node will not be null
		
		if (currentNode != null) {
			// since the key is at current node
			// unlink the node from the current node
			
			pre_node.next = currentNode.next;
			
			System.out.println(key + " Found and deleted.");
		}
		
		
		// if key was not present at the list current node should be null
		if (currentNode == null) {
			System.out.println(key + " was not found!");
		}
		
		return list;
	}
	
	
	// method to delete a specific position
	public static JavaLinkedList deleteAtPosition(JavaLinkedList list, int index) {
		Node currentNode = list.root, preNode = null;
		
		// case 1
		// if index is 0 then root node to be deleted.
		
		if (index == 0 && currentNode != null) {
			list.root = currentNode.next;
			System.out.println(index + " element is deleted.");
			return list;
		}
		
		// case 2
		// if index is greater than 0 but less than the size of linked list
		
		int counter = 0;
		
		while(currentNode != null) {
			if (counter == index) {
				// position unlink from the current node of the list
				preNode.next = currentNode.next;
				
				System.out.println(index + " element is deleted.");
				break;
			}
			else {
				// if current position is not index
				// continue to next node
				
				preNode = currentNode;
				currentNode = currentNode.next;
				counter++;
			}
		}
		
		
		// case 3
		// the index is greater than the size of the linked list
		
		if (currentNode == null) {
			// display the message
			System.out.println(index + " element not found!");
		}
		
		return list;
	}
	
	
	public static JavaLinkedList deleteFromLast(JavaLinkedList list) {
		
		Node currentNode = list.root, preNode = null;
		
		while(currentNode.next != null) {
			preNode = currentNode;
			currentNode = currentNode.next;
		}
		
		if (currentNode.next == null) {
			preNode.next = null;
			System.out.println(currentNode.data + " is deleted.");
		}
		
		return list;
	}
	
	
	// method to reverse a linked list
	public static JavaLinkedList reverseList(JavaLinkedList list) {
		Node currentNode = list.root, preNode = null, nextNode = list.root;
		
		while(nextNode != null) {
			nextNode = nextNode.next;
			currentNode.next = preNode;
			preNode = currentNode;
			currentNode = nextNode;
		}
		
		list.root = preNode;
		
		return list;
	}

	
	public static void main(String[] args) {
		JavaLinkedList linkedlist = new JavaLinkedList();
		
		linkedlist = insert(linkedlist, 256);
		linkedlist = insert(linkedlist, 156);
		linkedlist = insert(linkedlist, 456);
		linkedlist = insert(linkedlist, 356);
		
		showList(linkedlist);
		
		System.out.println();
		
		deleteByKey(linkedlist, 256);
		deleteByKey(linkedlist, 356);
		
		linkedlist = deleteAtPosition(linkedlist, 0);
		
		showList(linkedlist);
	}
}
