package Ex;

import java.util.Arrays;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][]a1= {{3,1,3,3,0,0,0,3,3,3},{1,1,1,3,4,4,0,3,0,3},{1,1,1,4,4,1,1,2,0,0},{1,1,1,1,4,1,1,1,0,2},{1,1,1,4,2,2,2,2,0,2},{1,1,1,4,2,2,2,3,0,4},{2,3,1,3,0,2,3,3,3,4},{3,3,3,3,0,0,0,4,4,4}};
		for (int i=0; i<a1.length; i++)
		{
			System.out.println(Arrays.toString(a1[i]));
		}

		System.out.println("the biggest size is:  " + biggestRect(a1));

		System.out.println();
			int [] [] a3= {{1,2,3},{4,5,6},{7,8,9}};
				for (int i=0; i<a3.length; i++)
					System.out.println(Arrays.toString(a3[i]));
				double [][] avgA=new double [a3.length][a3[0].length];
				avgA= (average(a3));
				System.out.println();
				System.out.println("the avereg array is:");
				for (int i=0; i<a3.length; i++)
					System.out.println(Arrays.toString(avgA[i]));

	}

	public static int biggestRect(int[][] a)
	{
		int theMax=0;
		int tempIndex=0;
		int rocav=0;
		int orec=0;

		boolean b=true;

		for(int s1=0; s1<a.length; s1++)
		{
			for(int t1=0; t1<a[s1].length; t1++)
			{
				for(int s2=s1; s2<a.length ; s2++)
				{
					for(int t2=t1; t2<a[s1].length; t2++)
					{
						b=true;
						b=leagal(a,s1,t1,s2,t2);
						if (b)
						{
							rocav=t2-t1+1;
							orec=s2-s1+1;
							tempIndex=(rocav)*(orec);
						}

						if (tempIndex>theMax)
							theMax=tempIndex;
					}
				}
			}
		}
		return theMax;
	}

	public static boolean leagal(int [][]a,int s1,int t1,int s2, int t2)
	{		
		for(int s3=s1; s3<=s2; s3++)
		{
			for(int t3=t1; t3<=t2; t3++)
			{
				if (a[s1][t1]!=a[s3][t3])
					return false;
			}
		}

		return true;
	}


	public static double[][] average (int[][] a)
	{
		double [][] avgA=new double [a.length][a[0].length];
		boolean b=true;
		double sum=0.0;

		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length && b; j++)
			{
				if(i==0 && j==0 || i==(a.length-1) && j==0 || i==0 && j==(a[0].length-1) || i==(a.length-1) && j==(a[0].length-1))
				{
					if (i==0 && j==0)
					{
						sum=a[i][j]+a[i][j+1]+a[i+1][j]+a[i+1][j+1];
						avgA[i][j]=sum/4;
					}
					else 
					{
						if (i==(a.length-1) && j==0)
						{
							sum=a[i][j]+a[i-1][j]+a[i-1][j+1]+a[i][j+1];
							avgA[i][j]=sum/4;
						}

						else
						{
							if (i==0 && j==(a[0].length-1))
							{
								sum=a[i][j]+a[i][j-1]+a[i+1][j-1]+a[i+1][j];
								avgA[i][j]=sum/4;
							}
							else
							{
								if (i==(a.length-1) && j==(a[0].length-1))
								{
									sum=a[i][j]+a[i][j-1]+a[i-1][j-1]+a[i-1][j];
									avgA[i][j]=sum/4;
								}
							}
						}
					}
				}
				else
				{
					if( (0<i && i<a.length-1 && j==0) || (0<j && j<a[i].length-1 && i==0) || (0<i && i<a.length-1 && j==a[i].length-1) || (0<j && j<a[i].length-1 && i==a.length-1)) 
					{
						if (0<i && i<a.length-1 && j==0)
						{
							sum=a[i][j]+a[i-1][j]+a[i-1][j+1]+a[i][j+1]+ a[i+1][j+1] +a[i+1][j];
							avgA[i][j]=sum/6;
						}
						else
							if (0<j && j<a[i].length-1 && i==0)
							{
								sum=a[i][j]+a[i][j-1]+a[i+1][j-1]+a[i+1][j]+ a[i+1][j+1] +a[i][j+1];
								avgA[i][j]=sum/6;
							}
							else
							{
								if (0<i && i<a.length-1 && j==a[i].length-1 )
								{
									sum=a[i][j]+a[i-1][j]+a[i-1][j-1]+a[i][j-1]+ a[i+1][j-1] +a[i+1][j];
									avgA[i][j]=sum/6;
								}
								else
								{
									if (0<j && j<a[i].length-1 && i==a.length-1)
									{
										sum=a[i][j]+a[i][j-1]+a[i-1][j-1]+a[i-1][j]+ a[i-1][j+1] +a[i][j+1];
										avgA[i][j]=sum/6;
									}
								}
							}
					}
					else
					{
						sum=a[i][j]+a[i-1][j]+a[i-1][j+1]+a[i][j+1]+a[i+1][j+1]+a[i+1][j]+a[i+1][j-1]+a[i][j-1]+a[i-1][j-1];
						avgA[i][j]=sum/9;	
					}
				}
			}
		}
		return avgA;
	}
}

