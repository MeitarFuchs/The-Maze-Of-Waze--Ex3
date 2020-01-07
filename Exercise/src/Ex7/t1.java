package Ex7;

import Ex4.MyConsole;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1=MyConsole.readString("enter a String");
		String s2=MyConsole.readString("enter a String");
		boolean b=true;
		if (s1.length()==s2.length())
		{
			for (int i=0; i<s1.length() && b; i++)
			{
				if (s1.charAt(i)!=s2.charAt(i))
					b=false;
			}
		
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");
		}
		else
			System.out.println("no at all");
		
	}
}
