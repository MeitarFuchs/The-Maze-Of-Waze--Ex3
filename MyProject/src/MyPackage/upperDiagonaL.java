package MyPackage;

public class upperDiagonaL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] a= {{1,4,5},{0,2,6},{0,0,3}};
		int counter=1;
		int counterP=4;
		boolean b=true;
		for(int i=0; i<a.length && b;i++)
		{
			for (int j=0; j< a[i].length && b; j++)
			{

				if (i==j) // בודק את האלכסון
				{
					if (a[i][j]!=counter)
						b=false;
				}
				else
					if (a[i][j]!=counterP)
						b=false;
				counterP++;	
			}

			counter++;
		}
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");

	}

}

