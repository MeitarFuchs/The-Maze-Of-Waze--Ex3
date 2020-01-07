package Ex5A;

import java.util.Arrays;

public class t6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,2},{3,4},{5,6}};
		
		prArr2(a);
		
		prArr2(transpose(a));
	}
	public static int [][] transpose(int [][] a)
	{
		int [][] b= new  int [a[0].length] [a.length];

		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length; j++)
			{
				b[j][i]=a[i][j];
			}
		}
		return b;
	}
	public static void prArr2(int [][]a) 
	{

		for (int i=0; i<a.length;i++)
		{
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
