package SQ;

import java.util.Stack;

public class MyQueue2<T> {
	Stack<T> stackNewest, stackOldest;
	
	public MyQueue2() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
		
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
		
	}
	
	public void add(T value) {
		//push into the newest she has always the newest on the top
		stackNewest.push(value);
	}
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
}
