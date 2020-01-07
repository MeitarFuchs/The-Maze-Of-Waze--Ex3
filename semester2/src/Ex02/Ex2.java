package Ex02;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Ex2 {
	
	public static  int maxsum( Stack<Integer> s) {
		int maxsum=0;
		int sum=0;
		Stack <Integer> tempS= new Stack <Integer> ();
		if (!s.isEmpty())
		tempS.push(s.pop());
		while (!s.isEmpty()) {
			sum=tempS.peek();
			tempS.push(s.pop());
			sum+=tempS.peek();
			if(maxsum<sum) {
				maxsum=sum;
			}
		}
		
		while (!tempS.isEmpty()) {
			s.push(tempS.pop());
		}
		return maxsum;
	}

	public static int topbig(Stack<Integer> s1,Stack<Integer> s2) {
		int maxsumS2= maxsum(s2);
		int sumS1=0;
		
		Stack <Integer> tempS= new Stack <Integer> ();
		if (!s1.isEmpty())
		tempS.push(s1.pop());
		while (!s1.isEmpty()) {
			sumS1=tempS.peek();
			tempS.push(s1.pop());
			sumS1+=tempS.peek();
			if(maxsumS2<sumS1) {
				return sumS1;
			}
		}
		
		while (!tempS.isEmpty()) {
			s1.push(tempS.pop());
		}
		
		return 0;	
	}

	public static void func2(Queue<Integer> q, Stack<Integer> s) {
		Stack <Integer> tempS= new Stack <Integer> ();
		
		while (!s.isEmpty()) {
			tempS.push(s.pop());
		}
		 
		while (!tempS.isEmpty() && !q.isEmpty()) {
			if (q.peek() >= tempS.peek()) 
				s.push(tempS.pop());
			else
				s.push(q.remove());
		}
		
		if (tempS.isEmpty()) {
			while (!q.isEmpty()) {
				s.push(q.remove());
			}
		}
		else {
			while (!tempS.isEmpty()) {
				s.push(tempS.pop());
			}
		}
		
	}








	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack1 = new Stack<Integer>(); 
		Stack<Integer> stack2 = new Stack<Integer>(); 
		PriorityQueue<Integer> q= new PriorityQueue <Integer>();
		
        stack2.push(18); 
        stack2.push(4); 
        stack2.push(0); 
        
        stack1.push(20); 
        stack1.push(12);
        stack1.push(0);
       
        
        q.add(3);
        q.add(3);
        q.add(3);
        q.add(3);
        q.add(3);
        
      System.out.println("maxsum"+maxsum(stack1));
      System.out.println("topbig"+topbig(stack1, stack2));
		
        func2(q,stack1);
        System.out.println(stack1);
	}

}
