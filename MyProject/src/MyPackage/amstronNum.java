package MyPackage;

public class amstronNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int a=0;
		int b=0;
		int c=0;
		int sum=0;
		
		for (int i=100; i<1000; i++) {
			
			a=i%10;
			b=(i/10)%10;
			c=i/100;
			sum= (a*a*a)+(b*b*b)+(c*c*c);
			if (sum==i)
				System.out.println(i);
			
			
		}
		
		
		
		
		
	}

}
