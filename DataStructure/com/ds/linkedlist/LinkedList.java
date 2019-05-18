package com.ds.linkedlist;

public class LinkedList {

	Node head;
	Node tail;
	int length = 0;
	
	public Node insertAtHead(Node head, int data){
		
		try {
			Node newNode = new Node(data);
			newNode.setNext(head);
			head = newNode;
			length++;
			System.out.println("Inserted new element at head: " + head.getData());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return head;
	}
	
	public Node insertAtTail(Node tail, int data) {
		try {
			Node newNode = new Node(data);
			tail.setNext(newNode);
			tail = newNode;
			length++;
			System.out.println("Inserted new element at tail: " + tail.getData());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tail;
	}
	
	public boolean insertAtIndex(Node head, int data, int index) {
		boolean flag = true;
		int i = 1;
		try {
		while(head != null && i != index) {
			head = head.getNext();
			i++;
		}
		Node newNode = new Node(data);
		Node next = head.getNext();
		newNode.setNext(next);
		head.setNext(newNode);
		length++;
		
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
			length--;	
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
		length--;
		
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
		length--;
		
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
			list.length++;
		}
		
		list.print(list);

		// insert at head
		list.head = list.insertAtHead(list.head, 10);
		list.print(list);
		System.out.println("Head " + list.head.getData());
		
		// insert at tail
		list.tail = list.insertAtTail(list.tail, 20);
		list.print(list);

		// insert at index
		list.insertAtIndex(list.head, 30, 3);
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
