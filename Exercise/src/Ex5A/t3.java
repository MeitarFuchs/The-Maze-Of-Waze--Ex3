package Ex5A;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] a= {{1,2,3},{4,5,6},{7,8,9}};
		int sumT=0;
		sumT= trace(a);
		System.out.println(sumT);
		
	}
	public static int trace(int [][] a) 
	{
		int sum=0;

		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				if (i==j)
				sum+=a[i][j];
			}
		}
		return sum;
	}
}
