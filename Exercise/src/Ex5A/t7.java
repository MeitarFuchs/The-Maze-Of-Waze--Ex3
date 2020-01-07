package Ex5A;

public class t7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] a= {{0,2},{3,0},{5,0}};
		int z;
		z=numZeros(a);
		System.out.println("there are  "+ z +"  in this array");
	}

	public static int numZeros(int [][] a)
	{
		int countz=0;
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length; j++)
			{
				if(a[i][j]==0)
					countz++;
			}
		}
		return countz;

	}
}
