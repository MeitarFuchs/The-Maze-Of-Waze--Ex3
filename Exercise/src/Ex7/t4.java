package Ex7;

import Ex4.MyConsole;

public class t4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=MyConsole.readString("enter a String");
		
		char c;
		 c=s.charAt(0);
		int countC=1;
		
		for (int i=1; i<s.length(); i++)
		{
				if (s.charAt(i)==c)
					countC++;
				
		}
		
				System.out.println(countC);
	}
}
