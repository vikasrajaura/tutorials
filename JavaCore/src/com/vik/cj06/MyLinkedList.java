package com.vik.cj06;

public class MyLinkedList<T> {

	Node<T> head;
	Node<T> tail;

	void add(T data) {
		Node<T> node = new Node(data);
		if(head==null) head=node;
		
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next; 
		}
		temp.next = node;
	}
	

	
	
	
	
	static class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

}
