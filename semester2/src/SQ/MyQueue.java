package SQ;

import java.util.NoSuchElementException;
/*
 last -> 1 -> 2 -> 3 -> ..... -> first
 */
public class MyQueue<T> {
	private static class QueueNode<T>{
		private T data;
		private  QueueNode<T> next;

		//ctor
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void insert(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if(last!=null)
			last.next = t;
		last = t;
		//if there is two elem -> then u remove one -> then u add  one 
		
		if(first == null)
			first = last;
	}
	
	public T remove() {
		if(first ==null) throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if(first == null)
			last = null;
		return data;
	}
	
	public T head() { //peek
		if (first == null) throw new NoSuchElementException();
		
		return first.data;
	}
	public boolean isEmpty() {
		return first == null;
	}
	
	

}
