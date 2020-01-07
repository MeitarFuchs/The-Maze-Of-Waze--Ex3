package SQ;

import java.util.Stack;

public class SortStack {
	
	public static Stack<Integer> sort(Stack<Integer> s1){
		int temp;
		int count = 0;
		Stack<Integer> s2 = new Stack<Integer>(); 
		
		
		while (!s1.isEmpty()) {
			temp = s1.peek();
			s1.pop();
			
			while (!s2.isEmpty() && s2.peek() > temp) {
				s1.push(s2.peek());
				s2.pop();
				count++;
			}
			s2.push(temp);
			
			for(int i=0;i<count;i++) {
				s2.push(s1.pop());
				
			}
		}
		return s2;
	}
	
	public static void showStack(Stack<Integer> s) {
		Stack<Integer> s2 = new Stack<Integer>();
		s2.addAll(s);
		while(!s2.isEmpty()) {
			System.out.println(s2.peek());
			s2.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack <Integer> s = new Stack<Integer>(); 
	    s.push(10); 
	    s.push(30); 
	    s.push(20); 
	    s.push(5); 
	    s.push(1); 
	  
	    System.out.println("stack is "); 
	    showStack(s); 
	    
	    //Stack<Integer>s1 = new Stack<Integer>();
	    s = sort(s);
	    
	    System.out.println("after sorting ");
	    showStack(s);
	  
	}

}
