package Ex6;

public class t9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,2,3},{4,5,6},{7,8,9}};
		boolean b=true;
		b=colsSorted(a);
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static boolean colsSorted(int [][]mat)
	{
		boolean b=true;
		for(int i=0; i<mat.length && b; i++)
		{
			for(int j=0; j<mat[i].length && b; j++)
			{
				if (i<mat.length-1)
				{
					if (mat[i][j]>mat[i+1][j])
						b=false;
				}
			}
		}
		return b;
	}

}
