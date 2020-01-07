package Ex7;

import Ex4.MyConsole;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=MyConsole.readString("enter a String");
		boolean b=true;
		
		
		for (int i=0; i<s.length() && b; i++)
		{
				 if (s.charAt(i)!=s.charAt(s.length()-1-i))
					 b=false;
		}
		if (b)
			System.out.println("yes");
			else
				System.out.println("on");
	}
}
