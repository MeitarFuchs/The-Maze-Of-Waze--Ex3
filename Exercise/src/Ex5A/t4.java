package Ex5A;

public class t4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,2,3},{4,5,6},{7,8,9}};
		int sumT2=0;
		sumT2= trace2(a);
		System.out.println(sumT2);
		
	}
	public static int trace2(int [][] a)
	{
		int sum=0;

		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				if (i+j==a.length-1)
				sum+=a[i][j];
			}
		}
		return sum;
	}
}