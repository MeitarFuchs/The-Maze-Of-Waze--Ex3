package Ex5A;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {{1,2,3},{4,5,6}};
		int sumM=0;
		sumM= sumArr2(a);
		System.out.println(sumM);

	}
	public static int sumArr2(int [][]a) 
	{
		int sum=0;

		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				sum+=a[i][j];
			}
		}
		return sum;
	}
}
