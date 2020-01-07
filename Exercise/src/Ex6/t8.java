package Ex6;

import java.util.Arrays;

public class t8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {1,2,9,10,8};
		int b2;
		b2=biggest2(a);
		System.out.println(" the biggest2 is:  "+b2);
	}
	public static  int biggest2(int[] a) 
	{
		int b2;
		System.out.println(" befor "+Arrays.toString(a));
		a=isSorted(a);
		System.out.println(" after "+Arrays.toString(a));
		b2=a[a.length-2];
		return b2;
	}
	public static int  []  isSorted(int[] a) 
	{
		for (int i=0; i<a.length ; i++)
		{
			int j=0;
			while (j!=a.length-1)
			{
				if (a[j]>a[j+1]) 
				{
					int tamp=a[j];
					a[j]=a[j+1];
					a[j+1]=tamp;
				}
				j++;
			}		
		}
		return a;
	}
}
