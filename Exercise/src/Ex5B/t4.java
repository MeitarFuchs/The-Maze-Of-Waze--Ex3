package Ex5B;

public class t4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {1,2,3,2,1};
		boolean b;
		b=palindrom(a);
		if (b)
		System.out.println("yes");
		else
			System.out.println("on");
	}
	public static boolean palindrom(int [] a)
	{
		boolean b=true;
		
		for (int i=0; i<a.length && b; i++)
		{
			//for (int j=a.length-1 ; j>0 && b; j--)??????
			//{
				 if (a[i]!=a[a.length-1-i])
					 b=false;
			//}
		}
		return b;
	}
}
