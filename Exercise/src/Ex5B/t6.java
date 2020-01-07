package Ex5B;

import java.util.Arrays;

public class t6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= {1,2,3,4,5};
		System.out.println(Arrays.toString(a));
		a=swap(2,3,a);
		System.out.println(Arrays.toString(a));
	}
	public static int [] swap(int i, int j, int [] a)
	{
		int tamp;
		tamp=a[i];
		a[i]=a[j];
		a[j]=tamp;
		return a;
	}
}
