package com.ds.linkedlist;

public class LinkedList {

	Node head;
	Node tail;
	
	public boolean insertAtHead(Node newNode, Node head){
		boolean flag = true;
		try {
			newNode.setNext(head);
			head = newNode;
			System.out.println("Inserted new element at head: " + head.getData());
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean insertAtTail(Node newNode, Node tail) {
		boolean flag = true;
		try {
			tail.setNext(newNode);
			tail = newNode;
			System.out.println("Inserted new element at tail: " + tail.getData());
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean insertAtIndex(Node newNode, Node head, int index) {
		boolean flag = true;
		int i = 1;
		try {
		while(head != null && i != index) {
			head = head.getNext();
			i++;
		}
		Node next = head.getNext();
		newNode.setNext(next);
		head.setNext(newNode);
		
		System.out.println("Inserted new element at " + index + " index: " + newNode.getData());
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean deleteHead(Node head) {
		boolean flag = true;
		try {
			Node temp = head;
			head = head.getNext();
			
			System.out.println("Deleted element at head: " + temp.getData());
			temp = null;
			
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteTail(Node head, Node tail) {
		boolean flag = true;
		Node temp;
		
		while(head.getNext() != tail) {
			head = head.getNext();
		}
		
		temp = tail;
		tail = head;
		
		System.out.println("Deleted element at tail: " + temp.getData());
		temp = null;
		
		return flag;
	}

	public boolean deleteAtIndex(Node head, int index) {
		boolean flag = true;
		int i = 1;
		
		try {
		while(head != null && i != index) {
			head = head.getNext();
			i++;
		}
		
		Node temp = head.getNext();
		head.setNext(head.getNext().getNext());

		System.out.println("Deleted element at " + index + " index: " + temp.getData());
		temp = null;
		
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		for(int i = 0; i < 5; i++) {
			Node node = new Node((int)(Math.random() * 1000));
			//System.out.println(node.getData());
			if(list.head == null && list.tail == null) {
				list.head = node;
				list.tail = node;
			}else {
				list.tail.setNext(node);
				list.tail = node;
			}
		}
		
		list.print(list);

		// insert at head
		Node newHead = new Node(10);
		list.insertAtHead(newHead, list.head);
		list.print(list);
		
		// insert at tail
		Node newTail = new Node(20);
		list.insertAtTail(newTail, list.tail);
		list.print(list);

		// insert at index
		Node newElement = new Node(30);
		list.insertAtIndex(newElement, list.head, 3);
		list.print(list);
		
	}

	private void print(LinkedList list) {
		System.out.println("********List********");
		Node start = list.head;
		while(start != null) {
			System.out.println("\t" + start.getData());
			start = start.getNext();
		}
		System.out.println("********************");
	}
}
