package SQ;

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
	
	public  int maxsum( Stack<Integer> s) {
		int maxsum=0;
		int sum=0;
		Node<Integer> tempNode= new Node<Integer>();
		tempNode=s.top;
		while (tempNode.next!=null) {
			sum=tempNode.data;
			tempNode=tempNode.next;
			sum+=tempNode.data;
			 if(maxsum<sum) {
				 maxsum=sum;
			 }
		}
		return maxsum;
	}
	

	
	public static int topbig(Stack<Integer> s1,Stack<Integer> s2) {
		int maxS2= s2.maxsum(s2);
		int sumS1=0;
		Node<Integer> tempNode= new Node<Integer>();
		tempNode=s1.top;
		while (tempNode.next!=null) {
			sumS1=tempNode.data;
			tempNode=tempNode.next;
			sumS1+=tempNode.data;
			 if(maxS2<sumS1) {
				 return sumS1;
			 }
		}
		 return 0;	
	}
	
	
}