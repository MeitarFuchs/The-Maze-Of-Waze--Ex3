package Ex4;

import java.util.Arrays;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int [] a= {1, 2, 3 , 4 ,5 };
		int num;
		
		System.out.println("The original array:");
		System.out.println(Arrays.toString(a));
		for (int i=0; i<a.length/2;i++)
		{
				num=a[i];
				a[i]=a[a.length-1-i];
				a[a.length-1-i]=num;
		}
		System.out.println("after:");
		System.out.println(Arrays.toString(a));
	}

}
