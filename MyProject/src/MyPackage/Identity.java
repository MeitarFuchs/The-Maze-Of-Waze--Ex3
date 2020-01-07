package MyPackage;//האם במטריצה שלי יש 1 באלכסון והשאר 0

import java.util.Arrays;

public class Identity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] [] a= {{1,0,0},{0,1,0},{0,0,1}};
		boolean b=true;
		b= identity(a);
		
		if (b)	
			System.out.println("yes");
		else
			System.out.println("no");
		
	}
	
	public static boolean identity(int [][]a)
	{
		
		boolean b=true;
		for(int i=0; i<a.length && b;i++)
		{
			for (int j=0; j< a[i].length && b; j++)
			{

				if (i==j) //בודק את האלכסון
				{
					if (a[i][j]!=1)
						b=false;
				}
				else
					if (a[i][j]!=0)
						b=false;
			}
		}
		if (b)
			return true;
		else
			return false;
	}

}
