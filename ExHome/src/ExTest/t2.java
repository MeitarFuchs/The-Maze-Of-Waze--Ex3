package ExTest;

import java.util.Arrays;

import javax.swing.AbstractAction;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] mat={ {1,2,3},{4,5,6},{7,8,9}};
		for (int j = 0; j < mat.length; j++) {
			System.out.println(Arrays.toString (mat[j]));
		}
		tran(mat);


		int []arr= {1,0,0,0,1,1,0,0,0,0,1};
		System.out.println(sub(arr));

		double [] a={1.1, 2.5, 63.9, 1.12,  3.45, -4.4} ;
		System.out.println(smallestD(a));

	}
	public static void tran(int [][]mat)
	{
		int tamp=0;
		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < i; j++)
			{
				tamp= mat[i][j];
				mat[i][j]=mat[j][i];
				mat[j][i]=tamp;
			}

		}

		for (int j = 0; j < mat.length; j++) {
			System.out.println(Arrays.toString (mat[j]));
		}

	}

	public static int sub(int arr[]) 
	{			
		int count=0;
		int max=0;
		for (int i = 0; i < arr.length; i++) 
		{
			count=0;
			if (arr[i]==0)
			{	
				boolean b=true;
				for (int j = i; j < arr.length && b; j++) 
				{
					if (arr[j]==0)
						count++;
					else
						if (arr[j]==1)
							b=false;
				}
			}
			if (max<count)
				max=count;
		}
		return max;
	}

	public static double smallestD(double [] arr) {

		double minD=9999;
		double tampD=0.0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j =i+1; j < arr.length; j++)
			{
				tampD=Math.abs(arr[i]-arr[j]);
				if (tampD<minD)
					minD=tampD;

			}
		}
		return minD;

	}







}
