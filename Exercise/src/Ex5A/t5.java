package Ex5A;

public class t5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,3,8,5},{3,1,4,6},{8,4,1,7},{5,6,7,2}};
		boolean b;
		b=(checkSymmetry(a));
		if(b)
			System.out.println("yes");
		else
			System.out.println("no");
	}
	public static boolean checkSymmetry(int [][] a)
	{
		boolean b=true;
		
		for (int i=0; i<a.length && b; i++)
		{
			for (int j=0; j<a[i].length && b; j++)
			{
				if(a[i][j]!=a[j][i])
					b=false;
			}
		}
		
		if (b)
			return b;
		else
			return false;

	}
}
