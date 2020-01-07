package Ex4;

import java.util.Arrays;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int [] a= new int [10];

		for (int i=0; i<a.length;i++)
		{
			a[i]=(int)(Math.random()*20 +10); 
		}
		int max=a[0];
		int min=a[0];
		for (int i=0; i<a.length;i=i+1) 
		{
			if (a[i]>max)
				max=a[i];
			if (a[i]<min)
				min=a[i];
		}
		System.out.println(Arrays.toString(a));
		System.out.println("max = "+max+ "   min= " +min);

	}
}