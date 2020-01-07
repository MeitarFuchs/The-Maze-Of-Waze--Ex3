package Ex7;

import Ex4.MyConsole;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=MyConsole.readString("enter a String");
		System.out.println(" " +s);
		char c;
		String sNew=" ";
		
		for (int i=s.length()-1; i>=0 ; i--)
		{
				 c=s.charAt(i);
				 sNew+=c;
				
		}
		
				System.out.println(sNew);
	}
}
