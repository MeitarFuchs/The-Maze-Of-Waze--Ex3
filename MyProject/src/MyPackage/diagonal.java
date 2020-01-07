package MyPackage; //בודק האם במטריצה הריבועים שלי באלכסון יש מספרים מ1 למספר שנגנר האלכסון

import java.util.Arrays;

public class diagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] [] a= {{1,0,0},{0,2,0},{0,0,3}};
		int counter=1;
		boolean b=true;
		for(int i=0; i<a.length && b;i++)
		{
			for (int j=0; j< a[i].length && b; j++)
			{

				if (i==j) //בודק את האלכסון
				{
					if (a[i][j]!=counter)
						b=false;
				}
				else
					if (a[i][j]!=0)
						b=false;
			}

			counter++;
		}
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");

	}

}
