package Ex5A;

import java.util.Arrays;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,2,3},{4,5,6}};

		prArr2(a);
	}
	public static void prArr2(int [][]a) 
	{

		for (int i=0; i<a.length;i++)
		{
			System.out.println(Arrays.toString(a[i]));
		}
	}
	
}
