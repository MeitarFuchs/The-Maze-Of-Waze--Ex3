package Ex5B;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= {1,2,3,4,5};
		int sum=0;

		sum=arraySum(a);
		System.out.println(sum);
	}
	public static int arraySum(int []a) 
	{
		int sum=0;

		for (int i=0; i<a.length; i++)
		{
			sum+=a[i];
		}
		return sum;
	}
}
