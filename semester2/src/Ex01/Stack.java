package Ex01;

import java.util.EmptyStackException;

import javax.xml.soap.Node;

public class Stack<T>{
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(){
			this.data = null;
			this.next=null;
		}
	
		public Node(T data){
			this.data = data;
			this.next=null;
		}
	}
	//head of current stack

	private Node<T> top;
	int size;
	
	public Stack () {
		top=null;
		size=0;
	}
	public T pop() {
		if(top ==null ) throw new EmptyStackException();

		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		Node <T> t = new Node<T>(item);
		t.next = top;
		top = t;
	}

	public T top() { //peek
		if (top == null ) throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top==null;
	}

	public String toString() {
		return MyToString(top);
	}
	private String MyToString(Node <T> p) {
		if (p==null)
			return "-|";
		return MyToString(p.next)+" "+p.data;
	}


}
