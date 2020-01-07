package Ex5B;

import java.util.Arrays;

public class t5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {1,2,3,4,5};
		print(a);
		reverse(a);
	}
	public static void reverse(int [] a)
	{
		int tamp;

		for (int i=0; i<a.length/2; i++)
		{
			
			for (int j=a.length-1 ; j>a.length/2 ; j--)
			{
				a=swap(2,3,a);	 ???
			}
		}
		
		print(a);
	}
	
	public static int[] swap(int i, int j, int [] a)
	{
		int tamp;
		tamp=a[i];
		a[i]=a[j];
		a[j]=tamp;
		
		return a;
	}
	public static void print(int [] a)
	{
			System.out.println(Arrays.toString(a));
	}
	
}
