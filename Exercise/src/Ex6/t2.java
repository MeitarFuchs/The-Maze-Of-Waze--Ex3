package Ex6;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,2,3},{8,5,6}};
		boolean b=true;
		b=rowsSorted(a);
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	public static boolean rowsSorted(int [][]mat)
	{
		boolean b=true;
		for(int i=0; i<mat.length && b; i++)
			{
				b=isSorted(i,mat[i]);
				if (b==false)
					return b;
			}
		return b;
			
	}
	
	public static boolean isSorted(int i,int[]a)
	{
		boolean b=true;
		for (int j=0; j<a.length && b; j++)
		{
			if(j!=a.length-1)
			{
				if (a[j]>=a[j+1])
				{
					b=false;
				}
			}
		}		
		return b;
	}
}
