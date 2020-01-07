package ExTest;

import java.util.Arrays;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		marr(n);
		System.out.println(First("jjj abcd","agbc"));
		System.out.println(all(1234567890));
		
	}
	
	public static boolean all(int n) 
	{
		String s="";
		s+=n;
		boolean tov=true;
		boolean b=false;
		for (int i = 0; i < s.length()&& tov; i++)
		{
		for (int j = 0; j <=9; j++) {
		if (s.charAt(i)==j)
			b=true;
		}	
		if (b==false)
			tov=false;
		}
		return tov;
	}
	
	
public static String First(String s, String t)
{
	int x=0;
	if (s.length()<=t.length())
		x=s.length();
	else
		x=t.length();
	
	if (s.equals(t))
		return t;
	for (int i = 0; i < x; i++)
	{
		if ((int)s.charAt(i)<(int)t.charAt(i))
			return s;
		if ((int)s.charAt(i)>(int)t.charAt(i))
			return t;
	}
	if (s.length()<=t.length())
		return s;
	else
		return t;
}


	public static void marr(int n)
	{
		int [] a=new int [n];
		for (int i = 0; i < a.length; i++) 
		{
			a[i]=(int)(Math.random()*n);
		}
		System.out.println(Arrays.toString(a));
		System.out.println();
		int count=0;
		while(count<a.length) 
		{
			count++;
			for (int i = 0; i < a.length-1; i++) 
			{
				int tamp=0;

				if (a[i]>a[i+1])
				{tamp=a[i];
				a[i]=a[i+1];
				a[i+1]=tamp;
				}
			}
		}

		System.out.println(Arrays.toString(a));
	}

}
