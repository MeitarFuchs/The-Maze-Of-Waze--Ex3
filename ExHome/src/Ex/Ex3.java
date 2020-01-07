package  Ex;
import java.util.Random;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(encode( "abcdefg", -46));//אחורה
		System.out.println(decode( "abcdefg", -46)); // קדימה
		//System.out.println(divide(-500,500));
		boolean y = true;
		int a,b;
		for (int i = 0; i < 20000 ; i++) {
			a=(int)(Math.random()*100)-50;
			b=(int)(Math.random()*100)-50;
			if (b!= 0) {
				if ((a/b) != (divide(a, b))) {
					y = false;
					System.out.println(a+", "+b);
				}
			}
		}
		System.out.println(y);
	
		//System.out.println(prefix("gj","gjgjjjjj"));
//		String a="abcdefghijklmnop";
//		String x,y;
//		int d,e;
//		boolean r=true;
//		for (int i = 0; i <20000; i++) {
//			d= (int) (Math.random()*15);
//			e= (int) (Math.random()*15);
//			x=a.substring(0, d);
//			y=a.substring(0, e);
//			if (d<e && prefix(y, x)) {
//				r=false;
//			}
//			if (e<d && prefix(x, y)) {
//				r=false;
//			}
//		}
//		System.out.println(r);
	
}
	public static String encode(String s, int k)
	{
		String newS = "";
		if (k<0)
		{
			k=k*(-1);
			return decode(s,k);
		}

		if (k>=0)
		{
			k=k%26;
			for(int i=0; i<s.length(); i++)
			{
				int x=s.charAt(i);
				if (x-k<97)
				{
					x=s.charAt(i)-k+26;
				} 
				else
					x=x-k;

				newS= newS+(char)x;
			}
		}

		return newS;
	}

	public static String decode(String s, int k)
	{
		String newS = "";
		if (k<0)
		{
			k=k*(-1);
			return encode(s,k);
		}
		if (k>=0)
		{
			k=k%26;
			for(int i=0; i<s.length(); i++)
			{
				int x=s.charAt(i);
				if (x+k>122)
				{
					x=s.charAt(i)+k-26;
				} 
				else
					x=x+k;

				newS= newS+(char)x;
			}
		}
		return newS;
	}

	public static int divide(int a, int b)
	{		
		if (a>0 && b>0)
		{
			if (a-b==0)
				return 1 ;
			else
			{
				if (a-b>0)
					return 1+divide(a-b,b);
				else
					return 0;
			}
		}
		else
		{
			if (a<0 && b>0)
			{
				a=a*(-1);
				if (a-b==0)
					return -1 ;
				else
				{
					if (a-b>0)
						return (1+divide(a-b,b))*(-1);
					else
						return 0;
				}
			}
			else
			{
				if (a>0 && b<0)
				{
					if (a+b==0)
						return -1 ;
					else
					{
						if (a+b>0)
							return (-1+divide(a+b,b));
						else
							return 0;
					}
				}
				else
				{
					if (a<0 && b<0)
					{
						if (-a+b==0)
							return 1 ;
						else
						{
							if (-a+b>0)
								return 1+divide(a-b,b);
							else
								return 0;
						}
					}
				}
			}
		} 
		return 0;
	}

	public static boolean prefix(String s, String t)
	{
		if (s.length() > t.length())
			return false;

		if (s.equals(""))
			return true;
		else
		{
			if (s.charAt(0)==t.charAt(0))
				return prefix(s.substring(1), t.substring(1));
			else
				return false;
		}
	}

}
